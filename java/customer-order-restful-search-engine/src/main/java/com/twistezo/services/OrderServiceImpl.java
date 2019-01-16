package com.twistezo.services;

import com.twistezo.models.CustomerThreeOrdersResult;
import com.twistezo.models.CustomerTotalAmountResult;
import com.twistezo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<CustomerTotalAmountResult> findCustomersBySumOfAmount(String surname) {
        return this.orderDAO.findCustomersBySumOfAmount(surname);
    }

    @Override
    public List<CustomerThreeOrdersResult> findCustomersByThreeOrders(Date startDate, Date endDate, BigDecimal low, BigDecimal high) {
        return this.orderDAO.findCustomersByThreeOrders(startDate, endDate, low, high);
    }

//    @Override
//    public List<CustomerWrapper> customerWrapper(String surname, Date startDate, Date endDate, BigDecimal low, BigDecimal high) {
//        return this.orderDAO.customerWrapper(surname, startDate, endDate, low, high);
//    }

}
