package com.epam.task.fifth.parser;

public class ChainBuilder {

    public AbstractParserWithSuccessor build() {
        return new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LexemeParser()
                        )
                )
        );
    }

}
