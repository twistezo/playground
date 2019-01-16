package com.twistezo.repositories;

import com.twistezo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author twistezo (22.02.2017)
 */

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    List<Customer> findAllBySurnameStartsWith(String firstLetters);

}
