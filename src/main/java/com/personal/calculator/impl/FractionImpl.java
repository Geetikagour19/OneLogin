package com.personal.calculator.impl;

import com.personal.calculator.Fraction;

/**
 * Implementation for Fraction Interface.
 */
public class FractionImpl implements Fraction {

    /**
     * Numerator of the Fraction.
     */
    private long numerator;

    /**
     * Denominator of the Fraction.
     */
    private long denominator;

    /**
     * Default Constructor.
     */
    public FractionImpl() {
    }

    /**
     * Constructor for creating Fraction object with Numerator and Denominator input.
     *
     * @param numerator numerator of fraction.
     * @param denominator denominator of fraction
     */
    public FractionImpl(int numerator, int denominator) {
        this.numerator = new Long(numerator).intValue();
        this.denominator = new Long(denominator).intValue();
    }

    /**
     * Constructor for creating Fraction object with Numerator and Denominator input.
     *
     * @param numerator numerator of fraction.
     * @param denominator denominator of fraction
     */
    private FractionImpl(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Fraction initialize(String input) throws IllegalArgumentException{
        validateFractionFormat(input);

        try {
            // Whole Number
            if (!input.contains("/")) {
                numerator = Integer.parseInt(input);
                denominator = 1;
            }
            // Fraction.
            else {
                int wholeNumber = 0;
                String afterWholeNumber = input;

                // Mixed Fraction.
                if (input.contains("_")) {
                    wholeNumber = Integer.parseInt(input.split("_")[0]);
                    int fractionIndex = input.indexOf("_");
                    afterWholeNumber = input.substring(fractionIndex+1, input.length());
                }
                denominator = Integer.parseInt(afterWholeNumber.split("/")[1]);

                if (denominator == 0) {
                    denominator = 1;
                }

                numerator = Integer.parseInt(afterWholeNumber.split("/")[0]) + (wholeNumber * denominator);
            }
            simplifyFraction();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input is not numeric", e);
        }
        return this;
    }

    @Override
    public Fraction add(Fraction operand) {
        long numerator = this.numerator * operand.getDenominator() + operand.getNumerator() * this.denominator;
        long denominator = this.denominator * operand.getDenominator();

        return new FractionImpl(numerator, denominator).simplifyFraction();
    }

    @Override
    public Fraction subtract(Fraction operand) {
        long numerator = this.numerator * operand.getDenominator() - operand.getNumerator() * this.denominator;
        long denominator = this.denominator * operand.getDenominator();

        return new FractionImpl(numerator, denominator).simplifyFraction();
    }

    @Override
    public Fraction multiply(Fraction operand) {
        long numerator = this.numerator *  operand.getNumerator();
        long denominator = this.denominator * operand.getDenominator();

        return new FractionImpl(numerator, denominator).simplifyFraction();
    }

    @Override
    public Fraction divide(Fraction operand) {
        long numerator = this.numerator * operand.getDenominator() ;
        long denominator = this.denominator * operand.getNumerator();

        return new FractionImpl(numerator, denominator).simplifyFraction();
    }

    @Override
    public int getNumerator() {
        return new Long(numerator).intValue();
    }

    @Override
    public int getDenominator() {
        return new Long(denominator).intValue();
    }

    @Override
    public String toString() {
        simplifyFraction();

        long numeratorAbs = Math.abs(numerator);
        long denominatorAbs = Math.abs(denominator);
        if (denominatorAbs == 1) {
            return new String("" + numerator / denominator);
        }

        StringBuffer result = new StringBuffer();

        if (numeratorAbs > denominatorAbs) {
            result.append(numerator / denominator);
        }

        if (result.length() != 0) {
            result.append("_");
        }
        result.append(numeratorAbs % denominatorAbs).append("/").append(denominatorAbs);

        return result.toString();
    }

    /**
     * Validating the format for the fraction.
     *
     * @param input string representation of the fraction.
     */
    private void validateFractionFormat(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException("input is not alphanumeric");
        }

        // Contains whole number and numerator but not denominator.
        if (input.contains("_") && !input.contains("/")) {
            throw new IllegalArgumentException("input is not in proper format. Missing denominator");
        }
    }

    /**
     * Simplifies the Fraction by dividing the numerator and denominator with their greatest common divisor.
     *
     * @returns the Simplified fraction.
     */
    private Fraction simplifyFraction() {
        if (Math.abs(denominator) <= Math.abs(numerator)) {
            long gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }

        if (numerator > Integer.MAX_VALUE || numerator < Integer.MIN_VALUE) {
            throw new ArithmeticException("Numerator is out of Integer limit");
        }
        if (denominator > Integer.MAX_VALUE || denominator < Integer.MIN_VALUE) {
            throw new ArithmeticException("Denominator is out of Integer limit");
        }
        return this;
    }

    /**
     * Static function to find the greatest common divisor for two numbers.
     * Ideally it should go to a separate file as public method, but since we do not need a separate file right now,
     * it is kept here as a private in this file.
     * @param num1
     * @param num2
     *
     * @return greatest common divisor of the input numbers.
     */
    private static long findGCD(long num1, long num2) {
        if(num2 == 0){
            return num1;
        }
        return findGCD(num2, num1%num2);
    }
}
