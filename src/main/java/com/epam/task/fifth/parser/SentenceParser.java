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

        String[] words = text.split(SPLITERATOR);

        List<String> newWords = updateWords(words);

        Parser successor = getSuccessor();

        List<Component> components = newWords.stream()
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

    private List<String> updateWords(String[] words) {

        List<String> newWords = new ArrayList<>();

        boolean isExpression = false;
        StringBuilder expressionBuilder = new StringBuilder();

        for (String word : words) {

            if (word.charAt(0) == '[') {
                isExpression = true;

                if (word.length() > 1) {
                    expressionBuilder.append(word);
                }

                if (word.charAt(word.length() - 1) == ']') {
                    String expression = expressionBuilder.toString();

                    newWords.add(expression);

                    isExpression = false;
                }
            } else if (word.charAt(word.length() - 1) == ']') {
                expressionBuilder.append(" ").append(word);
                String expression = expressionBuilder.toString();

                newWords.add(expression);

                isExpression = false;
            } else {
                if (isExpression) {
                    expressionBuilder.append(" ").append(word);
                } else {
                    newWords.add(word);
                }
            }
        }

        return newWords;
    }
}
