package com.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twistezo (22.03.2017)
 * Command invoker class
 */
class Broker {
    private List<Order> orderList = new ArrayList<>();

    void takeOrder(Order order) {
        orderList.add(order);
    }

    void placeOrders() {
        for(Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
