package com.paru.trees;


public class TreeVisits {

    void inOrder(Tree root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(Tree root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.data + " ");
    }

    void preOrder(Tree root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }
}
