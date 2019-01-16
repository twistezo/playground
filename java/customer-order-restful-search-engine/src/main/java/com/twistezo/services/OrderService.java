package com.twistezo.services;

import com.twistezo.models.CustomerThreeOrdersResult;
import com.twistezo.models.CustomerTotalAmountResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

public interface OrderService {

    List<CustomerTotalAmountResult> findCustomersBySumOfAmount(String surname);
    List<CustomerThreeOrdersResult> findCustomersByThreeOrders(Date startDate, Date endDate, BigDecimal low, BigDecimal high);
}
