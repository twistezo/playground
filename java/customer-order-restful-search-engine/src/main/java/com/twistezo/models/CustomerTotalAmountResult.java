package com.twistezo.models;

import java.math.BigDecimal;

/**
 * @author twistezo (24.02.2017)
 *
 * Class for binding result from DB by specific Hibernate query
 */

public class CustomerTotalAmountResult {

    private Long id;
    private String surname;
    private BigDecimal totalAmount;

    public CustomerTotalAmountResult(Long id, String surname, BigDecimal totalAmount) {
        this.id = id;
        this.surname = surname;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
