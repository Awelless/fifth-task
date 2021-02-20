package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
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

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(words)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }
}
