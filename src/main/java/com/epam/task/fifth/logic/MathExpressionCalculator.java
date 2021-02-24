package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExpressionCalculator {

    private static final String TERMINAL_EXPRESSION_REGEX = "[+\\-*/]";
    private static final Pattern TERMINAL_EXPRESSION_PATTERN = Pattern.compile(TERMINAL_EXPRESSION_REGEX);

    private static final String NON_TERMINAL_EXPRESSION_REGEX = "\\d+";
    private static final Pattern NON_TERMINAL_EXPRESSION_PATTERN = Pattern.compile(NON_TERMINAL_EXPRESSION_REGEX);

    public double calculate(String text) {
        ExpressionContext context = new ExpressionContext();

        List<AbstractExpression> expressions = parseToExpressions(text);

        for (AbstractExpression expression : expressions) {
            expression.interpret(context);
        }

        return context.getResult();
    }

    private List<AbstractExpression> parseToExpressions(String text) {
        Matcher terminalMatcher = TERMINAL_EXPRESSION_PATTERN.matcher(text);

        Map<Integer, AbstractExpression> expressionMap = new TreeMap<>();

        while (terminalMatcher.find()) {
            String expressionString = terminalMatcher.group();

            int startIndex = terminalMatcher.start();

            switch (expressionString) {
                case "+":
                    expressionMap.put(startIndex, new SumExpression());
                    break;
                case "-":
                    expressionMap.put(startIndex, new SubtractExpression());
                    break;
                case "*":
                    expressionMap.put(startIndex, new MultiplyExpression());
                    break;
                case "/":
                    expressionMap.put(startIndex, new DivideExpression());
                    break;
                default:
                    break;
            }
        }

        Matcher nonTerminalMatcher = NON_TERMINAL_EXPRESSION_PATTERN.matcher(text);

        while (nonTerminalMatcher.find()) {
            String expressionString = nonTerminalMatcher.group();
            int number = Integer.parseInt(expressionString);

            int startIndex = nonTerminalMatcher.start();

            expressionMap.put(startIndex, new NonTerminalExpression(number));
        }

        List<AbstractExpression> expressions = new ArrayList<>();

        for (Map.Entry<Integer, AbstractExpression> entry : expressionMap.entrySet()) {
            expressions.add(entry.getValue());
        }

        return expressions;
    }
}
