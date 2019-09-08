package com.personal.calculator.impl;

import com.personal.calculator.FractionCalculator;
import com.personal.calculator.Fraction;

/**
 * Implementation of FractionCalculator Interface.
 */
public class FractionCalculatorImpl implements FractionCalculator {

    @Override
    public String calculate(String operand1, String operator, String operand2) throws ArithmeticException {

        Fraction fraction1 = new FractionImpl().initialize(operand1);
        Fraction fraction2 = new FractionImpl().initialize(operand2);

        if (operator.equals("+")) {
            return fraction1.add(fraction2).toString();
        } else if (operator.equals("-")) {
            return fraction1.subtract(fraction2).toString();
        } else if (operator.equals("*")) {
            return fraction1.multiply(fraction2).toString();
        } else if (operator.equals("/")) {
            return fraction1.divide(fraction2).toString();
        } else {
            throw new IllegalArgumentException("Invalid operator. Please provide *, /, +, -");
        }
    }
}
