package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class TextParserTest {

    private final Parser paragraphParser = Mockito.mock(ParagraphParser.class);

    private final Parser textParser = new TextParser(paragraphParser);

    @Test
    public void test() {
        //given
        String firstParagraphText = "Test 123.";
        String secondParagraphText = "A asd. B.";

        String text = firstParagraphText + "\n" + secondParagraphText;

        Component firstParagraph = new Composite(
                Collections.singletonList(
                        new Composite(
                                Arrays.asList(
                                        new Leaf(LeafType.WORD, "Test"),
                                        new Leaf(LeafType.WORD, "123")
                                )
                        )
                )
        );

        Component secondParagraph = new Composite(
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

        Component expected = new Composite(Arrays.asList(firstParagraph, secondParagraph));

        when(paragraphParser.parse(firstParagraphText)).thenReturn(firstParagraph);
        when(paragraphParser.parse(secondParagraphText)).thenReturn(secondParagraph);

        //when
        Component actual = textParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);

        verify(paragraphParser, times(1)).parse(firstParagraphText);
        verify(paragraphParser, times(1)).parse(secondParagraphText);
    }
}
