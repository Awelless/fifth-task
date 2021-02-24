package com.epam.task.fifth.entity.expression;

public class SumExpression implements AbstractExpression {
    @Override
    public void interpret(ExpressionContext expressionContext) {
        NonTerminalExpression firstNumber = expressionContext.pop();
        NonTerminalExpression secondNumber = expressionContext.pop();

        double value = firstNumber.getValue() + secondNumber.getValue();

        NonTerminalExpression newExpression = new NonTerminalExpression(value);
        expressionContext.add(newExpression);
    }
}
