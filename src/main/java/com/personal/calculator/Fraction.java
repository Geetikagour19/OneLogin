package com.personal.calculator;

/**
 * Interface defining the methods for Fraction.
 */
public interface Fraction {

    /**
     * Initializes a Fraction object from a string representation in proper or improper format.
     *
     * @param input : String representation of fraction
     * @return
     *
     * @exception : IllegalArgumentException if the input is of incorrect format.
     */
    Fraction initialize(String input) throws IllegalArgumentException;

    /**
     * Method to add two fractions.
     *
     * @param operand: The fraction object to be added.
     *
     * @return: object containing the result of addition of the fractions.
     */
    Fraction add(Fraction operand);

    /**
     * Method to subtract two fractions.
     *
     * @param operand: The fraction object to be subtracted from the fraction.
     *
     * @return: object containing the result of subtraction of the fractions.
     */
    Fraction subtract(Fraction operand);

    /**
     * Method to multiply two fractions.
     *
     * @param operand: The fraction object to be multiplied with the fraction.
     *
     * @return: object containing the result of multiplication of the fractions.
     */
    Fraction multiply(Fraction operand);

    /**
     * Method to divide two fractions.
     *
     * @param operand: The fraction object to be divided from the fraction.
     *
     * @return: object containing the result of division of the fractions.
     */
    Fraction divide(Fraction operand);

    /**
     * Method to get the numerator of the fraction.
     *
     * @return numerator of the fraction.
     */
    int getNumerator();

    /**
     * Method to get the denominator of the fraction.
     *
     * @return denominator of the fraction.
     */
    int getDenominator();
}
