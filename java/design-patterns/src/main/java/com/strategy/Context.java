package com.strategy;

/**
 * @author twistezo (21.03.2017)
 */
class Context {
    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
