package com.command;

/**
 * @author twistezo (22.03.2017)
 */
class BuyStock implements Order {
    private Stock abcStock;

    BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
