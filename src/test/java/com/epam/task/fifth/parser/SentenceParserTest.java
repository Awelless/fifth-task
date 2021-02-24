package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SentenceParserTest {

    private final Parser lexemeParser = Mockito.mock(LexemeParser.class);

    private final Parser sentenceParser = new SentenceParser(lexemeParser);

    @Test
    public void testParse() {
        //given
        String firstLexemeText = "A";
        String secondLexemeText = "[5 3 +]";

        String text = firstLexemeText + " " + secondLexemeText;

        Component firstLexeme = new Leaf(LeafType.WORD, "A");
        Component secondLexeme = new Leaf(LeafType.MATH_EXPRESSION, "[5 3 +]");

        Component expected = new Composite(Arrays.asList(firstLexeme, secondLexeme));

        when(lexemeParser.parse(firstLexemeText)).thenReturn(firstLexeme);
        when(lexemeParser.parse("[5 3 +]")).thenReturn(secondLexeme);

        //when
        Component actual = sentenceParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);

        verify(lexemeParser, times(1)).parse(firstLexemeText);
        verify(lexemeParser, times(1)).parse("[5 3 +]");
    }
}
