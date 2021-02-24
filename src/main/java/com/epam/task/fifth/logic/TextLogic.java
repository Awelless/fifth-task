package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite sortParagraphsByNumberOfSentences(Composite text) {

        List<Component> children = text.getChildren();

        List<Component> childrenToSort = new ArrayList<>(children);

        childrenToSort.sort((first, second) -> {
            //all children of text are paragraphs, so we can upcast them to Composite
            List<Component> firstChildren = ((Composite) first).getChildren();
            List<Component> secondChildren = ((Composite) second).getChildren();

            return firstChildren.size() - secondChildren.size();
        });

        return new Composite(childrenToSort);
    }

    public Composite sortWordsByLength(Composite sentence) {

        List<Component> children = sentence.getChildren();

        List<Component> childrenToSort = new ArrayList<>(children);

        childrenToSort.sort((first, second) -> {
            //all children of sentence are lexemes, so we can upcast them to Leaf
            String firstLexeme = ((Leaf) first).getLexeme();
            String secondLexeme = ((Leaf) second).getLexeme();

            return firstLexeme.length() - secondLexeme.length();
        });

        return new Composite(childrenToSort);
    }
}
