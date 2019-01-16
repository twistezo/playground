package com.command;

/**
 * @author twistezo (22.03.2017)
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Stock absStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(absStock);
        SellStock sellStockOrder = new SellStock(absStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}
