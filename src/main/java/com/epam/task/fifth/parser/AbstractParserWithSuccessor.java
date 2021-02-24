package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractParserWithSuccessor implements Parser {

    private final Parser successor;

    public AbstractParserWithSuccessor(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected abstract String getSpliterator();

    @Override
    public Component parse(String text) {

        String spliterator = getSpliterator();

        String[] parts = text.split(spliterator);

        Parser successor = getSuccessor();

        List<Component> components = Arrays.stream(parts)
                .map(successor::parse)
                .collect(Collectors.toList());

        return new Composite(components);
    }
}
