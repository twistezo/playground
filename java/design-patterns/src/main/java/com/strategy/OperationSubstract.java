package com.strategy;

/**
 * @author twistezo (21.03.2017)
 */
class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
