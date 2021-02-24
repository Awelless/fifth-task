package com.epam.task.fifth.parser;

public class TextParser extends AbstractParserWithSuccessor {

    private static final String SPLITERATOR = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getSpliterator() {
        return SPLITERATOR;
    }
}
