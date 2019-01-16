package com.twistezo.services;

import com.twistezo.models.OrderDetail;
import com.twistezo.repositories.OrderDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Override
    public List<OrderDetail> findAll() {
        return this.orderDetailDAO.findAll();
    }
}
