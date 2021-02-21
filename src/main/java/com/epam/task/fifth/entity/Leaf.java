package com.epam.task.fifth.entity;

import com.epam.task.fifth.entity.lexeme.Lexeme;

public class Leaf implements Component {

    private final Lexeme lexeme;

    public Leaf(Lexeme lexeme) {
        this.lexeme = lexeme;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Leaf leaf = (Leaf) o;
        return lexeme.equals(leaf.lexeme);
    }

    @Override
    public int hashCode() {
        return lexeme.hashCode();
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "lexeme=" + lexeme +
                '}';
    }
}
