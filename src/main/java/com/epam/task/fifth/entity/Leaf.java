package com.epam.task.fifth.entity;

public class Leaf implements Component {

    private final LeafType type;

    private final String lexeme;

    public Leaf(LeafType type, String lexeme) {
        this.type = type;
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
        return lexeme.equals(leaf.lexeme) && type.equals(leaf.type);
    }

    @Override
    public int hashCode() {
        return 31 * lexeme.hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "lexeme=" + lexeme +
                '}';
    }
}
