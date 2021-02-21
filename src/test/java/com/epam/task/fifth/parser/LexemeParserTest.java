package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.lexeme.Lexeme;
import com.epam.task.fifth.entity.lexeme.MathExpression;
import com.epam.task.fifth.entity.lexeme.Word;
import com.epam.task.fifth.entity.lexeme.expression.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LexemeParserTest {

    private final Parser lexemeParser = new LexemeParser();

    @Test
    public void testParseWord() {
        //given
        String text = "asd";

        Component expected = new Leaf(new Word(text));

        //when
        Component actual = lexemeParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseExpression() {
        //given
        String text = "[10 4 + 6 * 1 -]";

        List<AbstractExpression> expectedExpressions = Arrays.asList(
                new NonTerminalExpression(10),
                new NonTerminalExpression(4),
                new SumExpression(),
                new NonTerminalExpression(6),
                new MultiplyExpression(),
                new NonTerminalExpression(1),
                new SubtractExpression()
        );

        Component expected = new Leaf(new MathExpression(
                "[10 4 + 6 * 1 -]",
                expectedExpressions
        ));

        //when
        Component actual = lexemeParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);

        Lexeme lexeme = ((Leaf) actual).getLexeme();

        Assert.assertEquals(expectedExpressions, ((MathExpression) lexeme).getExpressions());
    }
}
