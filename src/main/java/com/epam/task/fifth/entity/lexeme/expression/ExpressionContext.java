package com.epam.task.fifth.entity.lexeme.expression;

import java.util.Stack;

public class ExpressionContext {

    private final Stack<NonTerminalExpression> expressions = new Stack<>();

    public NonTerminalExpression get() {
        return expressions.pop();
    }

    public void add(NonTerminalExpression expression) {
        expressions.add(expression);
    }

    public double getResult() {
        return expressions.pop().getValue();
    }
}
