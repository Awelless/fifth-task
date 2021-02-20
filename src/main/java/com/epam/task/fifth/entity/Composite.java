package com.epam.task.fifth.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    public Composite(List<Component> children) {
        this.children = children;
    }

    public List<Component> getChildren() {
        return children;
    }

    public void addChild(Component component) {
        children.add(component);
    }

    public void removeChild(Component component) {
        children.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Composite composite = (Composite) o;
        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return children.hashCode();
    }

    @Override
    public String toString() {
        return "Composite{" +
                "children=" + children +
                '}';
    }
}
