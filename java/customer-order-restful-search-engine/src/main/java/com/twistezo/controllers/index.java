package com.twistezo.controllers;

import com.twistezo.models.CustomerThreeOrdersResult;
import com.twistezo.models.CustomerTotalAmountResult;
import com.twistezo.services.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Controller
public class index {

    private OrderService orderService;

    public index(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String test (Model model,
                        @RequestParam(value = "name", defaultValue = "", required = false) String surname,
                        @RequestParam(value = "start_date", defaultValue = "01-01-1800", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date startDate,
                        @RequestParam(value = "end_date", defaultValue = "01-01-2500", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date endDate,
                        @RequestParam(value = "low_price", defaultValue = "0", required = false) BigDecimal low,
                        @RequestParam(value= "high_price", defaultValue = "9999999999", required = false) BigDecimal high) {

        List<CustomerTotalAmountResult> customerTotalAmountResult = orderService.findCustomersBySumOfAmount(surname);
        model.addAttribute("customerTotalAmountResult", customerTotalAmountResult);

        List<CustomerThreeOrdersResult> customerThreeOrders = orderService.findCustomersByThreeOrders(startDate, endDate, low, high);
        model.addAttribute("customerThreeOrders", customerThreeOrders);

        return "index";
    }

}