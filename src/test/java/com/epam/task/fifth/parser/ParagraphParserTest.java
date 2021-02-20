package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ParagraphParserTest {

    private final Parser sentenceParser = Mockito.mock(SentenceParser.class);

    private final Parser paragraphParser = new ParagraphParser(sentenceParser);

    @Test
    public void test() {
        //given
        String firstSentenceText = "A asd";
        String secondSentenceText = "B";

        String text = firstSentenceText + ". " + secondSentenceText + ".";

        Component firstSentence = new Composite(
                Arrays.asList(
                        new Leaf("A"),
                        new Leaf("asd")
                )
        );

        Component secondSentence = new Composite(
                Collections.singletonList(
                        new Leaf("B")
                )
        );

        Component expected = new Composite(Arrays.asList(firstSentence, secondSentence));

        when(sentenceParser.parse(firstSentenceText)).thenReturn(firstSentence);
        when(sentenceParser.parse(secondSentenceText)).thenReturn(secondSentence);

        //when
        Component actual = paragraphParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);

        verify(sentenceParser, times(1)).parse(firstSentenceText);
        verify(sentenceParser, times(1)).parse(secondSentenceText);
    }
}
