package com.epam.task.fifth.entity.lexeme.expression;

public class SubtractExpression implements TerminalExpression {
    @Override
    public void interpret(ExpressionContext expressionContext) {
        NonTerminalExpression firstNumber = expressionContext.get();
        NonTerminalExpression secondNumber = expressionContext.get();

        double value = secondNumber.getValue() - firstNumber.getValue();

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
        return "SubtractExpression{}";
    }
}
