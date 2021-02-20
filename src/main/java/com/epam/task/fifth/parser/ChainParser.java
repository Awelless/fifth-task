package com.epam.task.fifth.parser;

public abstract class ChainParser implements Parser {

    private final Parser successor;

    public ChainParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }
}
