package com.command;

/**
 * @author twistezo (22.03.2017)
 * Request class
 */
class Stock {
    private String name = "ABC";
    private int quantity = 10;

    void buy() {
        System.out.println("Stock [ Name: " +name+ ", Quantity: " +quantity+ " ] bought");
    }

    void sell() {
        System.out.println("Stock [ Name: " +name+ ", Quantity: " +quantity+ " ] sold");
    }
}
