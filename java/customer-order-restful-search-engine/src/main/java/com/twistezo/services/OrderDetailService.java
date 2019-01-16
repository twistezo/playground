package com.twistezo.services;

import com.twistezo.models.Order;
import com.twistezo.models.OrderDetail;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

public interface OrderDetailService {

    List<OrderDetail> findAll();

}
