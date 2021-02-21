package com.epam.task.fifth.entity.lexeme;

import com.epam.task.fifth.entity.lexeme.expression.AbstractExpression;

import java.util.Collections;
import java.util.List;

public class MathExpression implements Lexeme {

    private final String value;

    private final List<AbstractExpression> expressions;

    public MathExpression(String value, List<AbstractExpression> expressions) {
        this.value = value;
        this.expressions = Collections.unmodifiableList(expressions);
    }

    public String getValue() {
        return value;
    }

    public List<AbstractExpression> getExpressions() {
        return expressions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        MathExpression mathExpression = (MathExpression) o;
        return value.equals(mathExpression.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Expression{" +
                "value='" + value + '\'' +
                '}';
    }
}