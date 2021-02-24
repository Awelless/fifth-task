package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends ChainParser {

    private static final String SPLITERATOR = " +";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {

        String[] lexemes = text.split(SPLITERATOR);

        List<String> rebuildedLexemes = rebuildLexemes(lexemes);

        Parser successor = getSuccessor();

        List<Component> components = rebuildedLexemes.stream()
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

    private List<String> rebuildLexemes(String[] lexemes) {

        List<String> rebuildedLexemes = new ArrayList<>();

        boolean isExpression = false;
        StringBuilder expressionBuilder = new StringBuilder();

        for (String lexeme : lexemes) {

            if (lexeme.charAt(0) == '[') {
                isExpression = true;

                if (lexeme.length() > 1) {
                    expressionBuilder.append(lexeme);
                }

                if (lexeme.charAt(lexeme.length() - 1) == ']') {
                    String expression = expressionBuilder.toString();

                    rebuildedLexemes.add(expression);

                    isExpression = false;
                }
            } else if (lexeme.charAt(lexeme.length() - 1) == ']') {
                expressionBuilder.append(" ").append(lexeme);
                String expression = expressionBuilder.toString();

                rebuildedLexemes.add(expression);

                isExpression = false;
            } else {
                if (isExpression) {
                    expressionBuilder.append(" ").append(lexeme);
                } else {
                    rebuildedLexemes.add(lexeme);
                }
            }
        }

        return rebuildedLexemes;
    }
}
