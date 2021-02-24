package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
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
                                        new Leaf(LeafType.WORD, "A"),
                                        new Leaf(LeafType.WORD, "asd")
                                )
                        ),
                        new Composite(
                                Collections.singletonList(
                                        new Leaf(LeafType.WORD, "B")
                                )
                        )
                )
        );

        Component secondParagraph = new Composite(
                Collections.singletonList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(LeafType.WORD, "Test"),
                                        new Leaf(LeafType.WORD, "123")
                                )
                        )
                )
        );

        Composite expected = new Composite(Arrays.asList(secondParagraph, firstParagraph));

        Composite unsortedParagraphs = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        //when
        Composite actual = textLogic.sortParagraphsByNumberOfSentences(unsortedParagraphs);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsByLength() {
        //given
        Component firstLexeme = new Leaf(LeafType.WORD, "ashf");
        Component secondLexeme = new Leaf(LeafType.WORD, "A");

        Composite expected = new Composite(Arrays.asList(secondLexeme, firstLexeme));

        Composite unsortedLexemes = new Composite(Arrays.asList(firstLexeme, secondLexeme));

        //when
        Composite actual = textLogic.sortWordsByLength(unsortedLexemes);

        Assert.assertEquals(expected, actual);
    }
}
