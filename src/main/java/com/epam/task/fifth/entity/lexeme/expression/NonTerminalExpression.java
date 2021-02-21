package com.epam.task.fifth.entity.lexeme.expression;

public class NonTerminalExpression implements AbstractExpression {

    private final double value;

    public NonTerminalExpression(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void interpret(ExpressionContext expressionContext) {
        expressionContext.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        NonTerminalExpression that = (NonTerminalExpression) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(value).hashCode();
    }

    @Override
    public String toString() {
        return "NonTerminalExpression{" +
                "value=" + value +
                '}';
    }
}
