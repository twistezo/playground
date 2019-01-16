package com.twistezo.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

/**
 * @author twistezo (22.02.2017)
 */

@Entity
@Table(name = "orders_details")
public class OrderDetail {

    public OrderDetail(){
        super();
    }

    public OrderDetail(String itemName, BigDecimal itemPrice, Order order) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.order = order;
    }

    @Id
    @Column(name = "order_detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_name", length = 50)
    private String itemName;

    @Digits(integer = 5, fraction = 2)
    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
