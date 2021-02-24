package com.epam.task.fifth.logic;

import org.junit.Assert;
import org.junit.Test;

public class MathExpressionCalculatorTest {

    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    private static final double DELTA = 0.01;

    @Test
    public void testCalculate() {
        //given
        String expression = "[10 4 + 6 * 1 -]";

        double expected = 83.0;

        //when
        double actual = calculator.calculate(expression);

        //then
        Assert.assertEquals(expected, actual, DELTA);
    }
}
