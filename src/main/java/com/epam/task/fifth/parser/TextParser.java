package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser extends ChainParser {

    private static final String SPLITERATOR = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {

        String[] paragraphs = text.split(SPLITERATOR);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(paragraphs)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }
}
