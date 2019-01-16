package com.twistezo.services;

import com.twistezo.models.Customer;
import com.twistezo.repositories.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public List<Customer> findAllBySurnameStartsWith(String firstLetters) {
        return this.customerDAO.findAllBySurnameStartsWith(firstLetters);
    }

}
