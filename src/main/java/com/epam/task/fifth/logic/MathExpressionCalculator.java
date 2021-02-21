package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.lexeme.MathExpression;
import com.epam.task.fifth.entity.lexeme.expression.AbstractExpression;
import com.epam.task.fifth.entity.lexeme.expression.ExpressionContext;

import java.util.List;

public class MathExpressionCalculator {

    public double calculate(MathExpression mathExpression) {
        ExpressionContext context = new ExpressionContext();

        List<AbstractExpression> expressions = mathExpression.getExpressions();

        for (AbstractExpression expression : expressions) {
            expression.interpret(context);
        }

        return context.getResult();
    }
}
