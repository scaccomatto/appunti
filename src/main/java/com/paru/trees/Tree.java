package com.paru.trees;

import java.util.LinkedList;
import java.util.List;

public class Tree {

    private int data;
    private List<Tree> children;

    public Tree (int initializationData){
        this.data = initializationData;
        children = new LinkedList<>();
    }

    public int getData() {
        return data;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void addChildren(Tree futureSon){
        children.add(futureSon);
    }

    public void printPreOrder(){
        preOrder(this);
    }

    private void preOrder(Tree t){
        if(t==null)
            return;
        System.out.println(t.data);
        for(Tree son: children){
            preOrder(son);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Tree)) return false;

        Tree tree = (Tree) o;

        return getData() == tree.getData();
    }

    @Override
    public int hashCode() {
        return getData();
    }
}
