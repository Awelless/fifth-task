package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.lexeme.MathExpression;
import com.epam.task.fifth.entity.lexeme.expression.MultiplyExpression;
import com.epam.task.fifth.entity.lexeme.expression.NonTerminalExpression;
import com.epam.task.fifth.entity.lexeme.expression.SubtractExpression;
import com.epam.task.fifth.entity.lexeme.expression.SumExpression;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MathExpressionCalculatorTest {

    private final MathExpressionCalculator calculator = new MathExpressionCalculator();

    private static final double DELTA = 0.01;

    @Test
    public void testCalculate() {
        //given
        MathExpression mathExpression = new MathExpression(
                "[10 4 + 6 * 1 -]",
                Arrays.asList(
                        new NonTerminalExpression(10),
                        new NonTerminalExpression(4),
                        new SumExpression(),
                        new NonTerminalExpression(6),
                        new MultiplyExpression(),
                        new NonTerminalExpression(1),
                        new SubtractExpression()
                )
        );

        double expected = 83.0;

        //when
        double actual = calculator.calculate(mathExpression);

        //then
        Assert.assertEquals(expected, actual, DELTA);
    }
}
