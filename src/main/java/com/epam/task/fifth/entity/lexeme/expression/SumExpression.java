package com.epam.task.fifth.entity.lexeme.expression;

public class SumExpression implements TerminalExpression {
    @Override
    public void interpret(ExpressionContext expressionContext) {
        NonTerminalExpression firstNumber = expressionContext.get();
        NonTerminalExpression secondNumber = expressionContext.get();

        double value = firstNumber.getValue() + secondNumber.getValue();

        NonTerminalExpression newExpression = new NonTerminalExpression(value);
        expressionContext.add(newExpression);
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "SumExpression{}";
    }
}
