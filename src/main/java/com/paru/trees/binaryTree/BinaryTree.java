package com.paru.trees.binaryTree;

public class BinaryTree {

    private int data;
    private BinaryTree left;
    private  BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public BinaryTree getNodeByData(int data){

        return searchNode(data, this);
    }

    public void setNode(int data){
        BinaryTree target = getNodeByData(data);

        if(target == null) {
            insertNode(data, this);
        }
    }

    private void insertNode(int data, BinaryTree binaryTree) {

        if (data > binaryTree.getData()) {

            if(binaryTree.getRight()==null){
                binaryTree.setRight(new BinaryTree(data));
            } else {
                insertNode(data, binaryTree.getRight());
            }
        }

        if (data < binaryTree.getData()) {
            if(binaryTree.getLeft()==null){
                binaryTree.setLeft(new BinaryTree(data));
            } else {
                insertNode(data, binaryTree.getLeft());
            }
        }
    }

    private static BinaryTree searchNode(int data, BinaryTree tree) {

        if (tree == null)
            return null;

        if(data == tree.getData()){
            return tree;
        }

        if (data > tree.getData()) {
            return searchNode(data, tree.getRight());
        }

        if (data < tree.getData()) {
            return searchNode(data, tree.getLeft());
        }

        return null;

    }
}
