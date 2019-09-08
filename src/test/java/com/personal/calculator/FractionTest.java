package com.personal.calculator;

import com.personal.calculator.Fraction;
import com.personal.calculator.impl.FractionImpl;
import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

    @Test
    public void testInitialize_withValidImproperFractionString_createsValidFraction() throws Exception {
        Fraction fraction = new FractionImpl().initialize("1/4");
        Assert.assertEquals(1, fraction.getNumerator());
        Assert.assertEquals(4, fraction.getDenominator());
        Assert.assertEquals("1/4", fraction.toString());
    }

    @Test
    public void testInitialize_withValidProperFractionString_createsValidFraction() throws Exception {
        Fraction fraction = new FractionImpl().initialize("3_1/4");
        Assert.assertEquals(13, fraction.getNumerator());
        Assert.assertEquals(4, fraction.getDenominator());
        Assert.assertEquals("3_1/4", fraction.toString());
    }

    @Test
    public void testInitialize_withValidProperFractionString_createsValidSimplifiedFraction() throws Exception {
        Fraction fraction = new FractionImpl().initialize("6/4");
        Assert.assertEquals(3, fraction.getNumerator());
        Assert.assertEquals(2, fraction.getDenominator());
        Assert.assertEquals("1_1/2", fraction.toString());
    }

    @Test
    public void testInitialize_withValidZeroDenominator_initilaizesFractionWithDenominatorOne() throws Exception {
        Fraction fraction = new FractionImpl().initialize("6/0");
        Assert.assertEquals(6, fraction.getNumerator());
        Assert.assertEquals(1, fraction.getDenominator());
        Assert.assertEquals("6", fraction.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitialize_withNullString_throwsIllegalArgumentException() throws Exception {
        new FractionImpl().initialize(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitialize_withEmptyString_throwsIllegalArgumentException() throws Exception {
        new FractionImpl().initialize("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitialize_withImproperFraction_throwsIllegalArgumentException() throws Exception {
        new FractionImpl().initialize("1_2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitialize_withNonNumericInput_throwsIllegalArgumentException() throws Exception {
        new FractionImpl().initialize("1/a");
    }

    @Test
    public void testAdd_withValidFraction_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl(3,2);
        Fraction fraction2 = new FractionImpl(4,5);
        Fraction fraction3 = fraction1.add(fraction2);

        Assert.assertEquals(23, fraction3.getNumerator());
        Assert.assertEquals(10, fraction3.getDenominator());
    }

    @Test
    public void testAdd_withInIntegerRange_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl(Integer.MAX_VALUE,2);
        Fraction fraction2 = new FractionImpl(Integer.MAX_VALUE,2);
        Fraction fraction3 = fraction1.add(fraction2);

        Assert.assertEquals(Integer.MAX_VALUE, fraction3.getNumerator());
        Assert.assertEquals(1, fraction3.getDenominator());
    }

    @Test
    public void testAdd_withNegativeFraction_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl().initialize("-21/5");
        Fraction fraction2 = new FractionImpl(4,5);
        Fraction fraction3 = fraction1.add(fraction2);

        Assert.assertEquals(-17, fraction3.getNumerator());
        Assert.assertEquals(5, fraction3.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testAdd_numeratorMoreThanMaxIntValue_throwsArithmeticException() throws Exception {
        Fraction fraction1 = new FractionImpl(Integer.MAX_VALUE,1);
        Fraction fraction2 = new FractionImpl(Integer.MAX_VALUE,1);
        fraction1.add(fraction2);
    }

    @Test(expected = ArithmeticException.class)
    public void testAdd_numeratorLessThanMinIntValue_throwsArithmeticException() throws Exception {
        Fraction fraction1 = new FractionImpl(Integer.MIN_VALUE,1);
        Fraction fraction2 = new FractionImpl(Integer.MIN_VALUE,1);
        fraction1.add(fraction2);
    }

    @Test
    public void testSubtract_withValidFraction_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl(3,2);
        Fraction fraction2 = new FractionImpl(4,5);
        Fraction fraction3 = fraction1.subtract(fraction2);

        Assert.assertEquals(7, fraction3.getNumerator());
        Assert.assertEquals(10, fraction3.getDenominator());
    }

    @Test
    public void testMultiply_withValidFraction_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl(3,2);
        Fraction fraction2 = new FractionImpl(4,5);
        Fraction fraction3 = fraction1.multiply(fraction2);

        Assert.assertEquals(6, fraction3.getNumerator());
        Assert.assertEquals(5, fraction3.getDenominator());
    }


    @Test(expected = ArithmeticException.class)
    public void testMultiply_denominatorMoreThanMaxIntValue_throwsArithmeticException() throws Exception {
        Fraction fraction1 = new FractionImpl(2, Integer.MAX_VALUE);
        Fraction fraction2 = new FractionImpl(3, 10);
        fraction1.multiply(fraction2);
    }

    @Test(expected = ArithmeticException.class)
    public void testMultiply_denominatorLessThanMinIntValue_throwsArithmeticException() throws Exception {
        Fraction fraction1 = new FractionImpl(2, Integer.MIN_VALUE);
        Fraction fraction2 = new FractionImpl(3, 10);
        fraction1.multiply(fraction2);
    }
    @Test
    public void testDivide_withValidFraction_returnsCorrectFraction() throws Exception {
        Fraction fraction1 = new FractionImpl(3,2);
        Fraction fraction2 = new FractionImpl(4,5);
        Fraction fraction3 = fraction1.divide(fraction2);

        Assert.assertEquals(15, fraction3.getNumerator());
        Assert.assertEquals(8, fraction3.getDenominator());
    }
}
