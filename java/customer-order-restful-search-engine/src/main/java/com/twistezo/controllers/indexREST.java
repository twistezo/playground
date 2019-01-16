package com.twistezo.controllers;

import com.twistezo.models.CustomerTotalAmountResult;
import com.twistezo.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author twistezo (28.02.2017)
 * Example of RESTful controller
 * Web: http://localhost:8080/rest?id=2&name=Zet&amount=400
 */

@RestController
public class indexREST {

    /*
    Dependency injection by constructor
     */
    private OrderService orderService;

    public indexREST(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping("/rest")
    public CustomerTotalAmountResult customerTotalAmountResult(
            @RequestParam(value = "id", defaultValue = "0", required = false) Long id,
            @RequestParam(value = "surname", defaultValue = "error", required = false) String surname,
            @RequestParam(value = "amount", defaultValue = "0", required = false) BigDecimal amount) {

        orderService.findCustomersBySumOfAmount(surname);

        return new CustomerTotalAmountResult(id, surname, amount);
    }
}
