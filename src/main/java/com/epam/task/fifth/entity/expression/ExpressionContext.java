package com.epam.task.fifth.entity.expression;

import java.util.ArrayDeque;

public class ExpressionContext {

    private final ArrayDeque<NonTerminalExpression> expressions = new ArrayDeque<>();

    public NonTerminalExpression pop() {
        return expressions.pop();
    }

    public void add(NonTerminalExpression expression) {
        expressions.add(expression);
    }

    public double getResult() {
        return expressions.pop().getValue();
    }
}
