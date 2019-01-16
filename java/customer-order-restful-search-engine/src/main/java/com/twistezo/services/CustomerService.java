package com.twistezo.services;

import com.twistezo.models.Customer;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

public interface CustomerService {

    List<Customer> findAll();
    List<Customer> findAllBySurnameStartsWith(String firstLetters);

}
