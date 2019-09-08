package com.personal.calculator;

/**
 * Interface defining the methods for calculating the equation.
 */
public interface FractionCalculator {

    /**
     * Calculates the equation provided in the form of `Operand1 operator Operand2`. This API supports only the range of 4 byte Integer values.
     *
     * @param operand1 String operand 1
     * @param operator String operator
     * @param operand2 String operand 2
     *
     * @return String: The value of the equation in string format.
     *
     * @exception ArithmeticException If the operation goes out of valid range for Integer, it throws ArithmeticException.
     * @exception IllegalArgumentException If arguments are not in proper format.
     */
    String calculate(String operand1, String operator, String operand2) throws ArithmeticException, IllegalArgumentException;

}
