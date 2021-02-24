package com.epam.task.fifth.parser;

public class ParagraphParser extends AbstractParserWithSuccessor {

    private static final String SPLITERATOR = "((\\.{3})|\\.|!|\\?) ?";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    protected String getSpliterator() {
        return SPLITERATOR;
    }
}
