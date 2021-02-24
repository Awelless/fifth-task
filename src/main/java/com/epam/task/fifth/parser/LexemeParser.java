package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;

public class LexemeParser implements Parser {

    private static final String MATH_EXPRESSION_REGEX = "\\[.*]";

    @Override
    public Component parse(String text) {
        if (text.matches(MATH_EXPRESSION_REGEX)) {
            return new Leaf(LeafType.MATH_EXPRESSION, text);
        }

        return new Leaf(LeafType.WORD, text);
    }
}
