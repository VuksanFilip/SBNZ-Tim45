package com.ftn.sbnz.model;

import org.kie.api.definition.type.Position;

public class BackwardModel {

    @Position(0)
    private String child;

    @Position(1)
    private String parent;

    public BackwardModel(String child, String parent) {
        this.child = child;
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        BackwardModel backwardModel = (BackwardModel) o;

        if (child != null ? !child.equals(backwardModel.child) : backwardModel.child != null) { return false; }
        if (parent != null ? !parent.equals(backwardModel.parent) : backwardModel.parent != null) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = child != null ? child.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BackwardModel{" +
                "child='" + child + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

}
