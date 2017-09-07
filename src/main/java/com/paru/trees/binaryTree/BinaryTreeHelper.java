package com.paru.trees.binaryTree;

public class BinaryTreeHelper {

    static BinaryTree lowestCommonAnchestor(BinaryTree root, int v1, int v2) {

        if (root == null)
            return null;


        if (v1 > root.getData() && v2 > root.getData()) {
            return lowestCommonAnchestor(root.getRight(), v1, v2);
        }

        if (v1 < root.getData() && v2 < root.getData()) {
            return lowestCommonAnchestor(root.getLeft(), v1, v2);
        }
        return root;
    }

    public static BinaryTree searchNode(int data, BinaryTree tree) {

        if (tree == null)
            return null;

        if(tree.getData()==data){
            return tree;
        }

        if (data < tree.getData()) {
            return searchNode(data, tree.getLeft());
        }

        if (data > tree.getData()) {
            return searchNode(data, tree.getRight());
        }

        return null;

    }

    public static Integer findMax(BinaryTree tree){

        if(tree == null)
            return Integer.MIN_VALUE;

        int result = tree.getData();
        int lMax = findMax(tree.getLeft());
        int rMax = findMax(tree.getRight());

        if(lMax>result){
            result = lMax;
        }
        if(rMax>result){
            result = rMax;
        }
        return result;
    }
}
