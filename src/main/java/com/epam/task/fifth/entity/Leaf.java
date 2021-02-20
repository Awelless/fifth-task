package com.epam.task.fifth.entity;

public class Leaf implements Component {

    private final String lexeme;

    public Leaf(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
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
