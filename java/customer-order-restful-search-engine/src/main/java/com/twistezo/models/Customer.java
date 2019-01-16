package com.twistezo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author twistezo (22.02.2017)
 */

@Entity
@Table(name = "customers")
public class Customer {

    public Customer(){
        super();
    }

    public Customer(String name, String surname, Set<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.orders = orders;
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}