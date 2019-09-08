package com.personal.calculator;

import com.personal.calculator.impl.FractionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;
public class FractionCalculatorTest {

    private static final FractionCalculator FRACTION_CALCULATOR = new FractionCalculatorImpl();

    @Test
    public void testCalculate_withValidInputForAdd_returnsValidResult() throws Exception {
        String result = FRACTION_CALCULATOR.calculate("3/2", "+", "2");
        Assert.assertEquals("3_1/2", result);
    }

    @Test
    public void testCalculate_withValidInputForSubtraction_returnsValidResult() throws Exception {
        String result = FRACTION_CALCULATOR.calculate("6", "-", "2/3");
        Assert.assertEquals("5_1/3", result);
    }

    @Test
    public void testCalculate_withValidInputForMultiplication_returnsValidResult() throws Exception {
        String result = FRACTION_CALCULATOR.calculate("6", "*", "1/2");
        Assert.assertEquals("3", result);
    }

    @Test
    public void testCalculate_withValidInputForDivide_returnsValidResult() throws Exception {
        String result = FRACTION_CALCULATOR.calculate("6", "/", "5");
        Assert.assertEquals("1_1/5", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculate_withInvalidOperator_throwsIllegalArgumentException() throws Exception {
        FRACTION_CALCULATOR.calculate("6", "%", "2");
    }
}
