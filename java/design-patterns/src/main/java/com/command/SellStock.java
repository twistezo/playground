package com.command;

/**
 * @author twistezo (22.03.2017)
 */
class SellStock implements Order{
    private Stock abcStock;

    SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
