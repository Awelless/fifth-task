package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends ChainParser {

    private static final String SPLITERATOR = "((\\.{3})|\\.|!|\\?) ?";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {

        String[] sentences = text.split(SPLITERATOR);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(sentences)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }
}
