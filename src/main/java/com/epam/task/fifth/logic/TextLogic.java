package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.lexeme.Lexeme;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public Composite sortParagraphsByNumberOfSentences(Composite text) {

        List<Component> children = text.getChildren();

        List<Component> childrenToSort = new ArrayList<>(children);

        childrenToSort.sort((a, b) -> {
            //all children of text are paragraphs, so we can upcast them to Composite
            List<Component> aChildren = ((Composite) a).getChildren();
            List<Component> bChildren = ((Composite) b).getChildren();

            return aChildren.size() - bChildren.size();
        });

        return new Composite(childrenToSort);
    }

    public Composite sortWordsByLength(Composite sentence) {

        List<Component> children = sentence.getChildren();

        List<Component> childrenToSort = new ArrayList<>(children);

        childrenToSort.sort((a, b) -> {
            //all children of sentence are lexemes, so we can upcast them to Leaf
            Lexeme aLexeme = ((Leaf) a).getLexeme();
            Lexeme bLexeme = ((Leaf) b).getLexeme();

            String aLexemeValue = aLexeme.getValue();
            String bLexemeValue = bLexeme.getValue();

            return aLexemeValue.length() - bLexemeValue.length();
        });

        return new Composite(childrenToSort);
    }
}
