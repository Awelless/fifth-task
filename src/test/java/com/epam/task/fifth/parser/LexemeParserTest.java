package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class LexemeParserTest {

    private final Parser lexemeParser = new LexemeParser();

    @Test
    public void test() {
        //given
        String text = "asd";

        Component expected = new Leaf(text);

        //when
        Component actual = lexemeParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);
    }

}
