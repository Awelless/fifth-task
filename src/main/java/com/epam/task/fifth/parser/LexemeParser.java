package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;

public class LexemeParser implements Parser {
    @Override
    public Component parse(String text) {
        return new Leaf(text);
    }
}
