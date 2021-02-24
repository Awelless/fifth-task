package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceParser extends AbstractParserWithSuccessor {

    private static final String SPLITERATOR = " +";

    private static final String MATH_EXPRESSION_REGEX = "\\[.*]";
    private static final Pattern MATH_EXPRESSION_PATTERN = Pattern.compile(MATH_EXPRESSION_REGEX);

    public SentenceParser(Parser successor) {
        super(successor);
    }

    protected String getSpliterator() {
        return SPLITERATOR;
    }

    @Override
    public Component parse(String text) {

        List<String> lexemes = getLexemes(text);

        Parser successor = getSuccessor();

        List<Component> components = lexemes.stream()
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }

    private List<String> getLexemes(String text) {

        StringBuilder textBuilder = new StringBuilder(text);

        List<String> rebuildedLexemes = new ArrayList<>();

        Matcher matcher = MATH_EXPRESSION_PATTERN.matcher(textBuilder);

        while (matcher.find()) {
            String expression = matcher.group();

            int expressionStart = matcher.start();
            int expressionEnd = matcher.end();

            String textBeforeExpression = textBuilder.substring(0, expressionStart);

            String[] words = textBeforeExpression.split(SPLITERATOR);

            rebuildedLexemes.addAll(Arrays.asList(words));
            rebuildedLexemes.add(expression);

            textBuilder.replace(0, expressionEnd, "");
        }

        String remainingText = textBuilder.toString();

        if (remainingText.length() > 0 && !remainingText.matches(SPLITERATOR)) {
            String[] words = remainingText.split(SPLITERATOR);
            rebuildedLexemes.addAll(Arrays.asList(words));
        }

        return rebuildedLexemes;
    }
}
