package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.lexeme.Word;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private final TextLogic textLogic = new TextLogic();

    @Test
    public void testSortParagraphsByNumberOfSentences() {
        //given
        Component firstParagraph = new Composite(
                Arrays.asList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(new Word("A")),
                                        new Leaf(new Word("asd"))
                                )
                        ),
                        new Composite(
                                Collections.singletonList(
                                        new Leaf(new Word("B"))
                                )
                        )
                )
        );

        Component secondParagraph = new Composite(
                Collections.singletonList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(new Word("Test")),
                                        new Leaf(new Word("123"))
                                )
                        )
                )
        );

        Composite expected = new Composite(Arrays.asList(secondParagraph, firstParagraph));

        Composite toSort = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        //when
        Composite actual = textLogic.sortParagraphsByNumberOfSentences(toSort);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsByLength() {
        //given
        Component firstLexeme = new Leaf(new Word("ashf"));
        Component secondLexeme = new Leaf(new Word("A"));

        Composite expected = new Composite(Arrays.asList(secondLexeme, firstLexeme));

        Composite toSort = new Composite(Arrays.asList(firstLexeme, secondLexeme));

        //when
        Composite actual = textLogic.sortWordsByLength(toSort);

        Assert.assertEquals(expected, actual);
    }
}
