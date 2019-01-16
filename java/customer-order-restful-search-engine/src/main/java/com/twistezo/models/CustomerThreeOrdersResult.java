package com.twistezo.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author twistezo (25.02.2017)
 * Class for binding result from DB by specific Hibernate query
 */
public class CustomerThreeOrdersResult {

    private Long id;
    private String surname;
    private BigDecimal amount;
    private Date date;

    public CustomerThreeOrdersResult (Long id, String surname, BigDecimal amount, Date date) {
        this.id = id;
        this.surname = surname;
        this.amount = amount;
        this.date = date;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
