package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.lexeme.Lexeme;
import com.epam.task.fifth.entity.lexeme.MathExpression;
import com.epam.task.fifth.entity.lexeme.Word;
import com.epam.task.fifth.entity.lexeme.expression.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {

    private static final String MATH_EXPRESSION_REGEX = "\\[.*]";

    private static final String TERMINAL_EXPRESSION_REGEX = "[+\\-*/]";
    private static final Pattern TERMINAL_EXPRESSION_PATTERN = Pattern.compile(TERMINAL_EXPRESSION_REGEX);

    private static final String NON_TERMINAL_EXPRESSION_REGEX = "\\d+";
    private static final Pattern NON_TERMINAL_EXPRESSION_PATTERN = Pattern.compile(NON_TERMINAL_EXPRESSION_REGEX);

    @Override
    public Component parse(String text) {
        Lexeme lexeme;

        if (text.matches(MATH_EXPRESSION_REGEX)) {
            List<AbstractExpression> expressions = parseExpression(text);
            lexeme = new MathExpression(text, expressions);
        } else {
            lexeme = new Word(text);
        }

        return new Leaf(lexeme);
    }

    private List<AbstractExpression> parseExpression(String text) {
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

        while(nonTerminalMatcher.find()) {
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
