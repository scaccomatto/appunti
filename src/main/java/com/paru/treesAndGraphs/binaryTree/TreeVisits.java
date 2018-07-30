package com.paru.treesAndGraphs.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class TreeVisits {
    //most left first
    public static void inOrder(BinaryTree root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    //root last
    public static void postOrder(BinaryTree root) {
        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());

        System.out.print(root.getData() + " ");
    }

    //root first
    public static void preOrder(BinaryTree root) {
        if (root == null)
            return;

        System.out.print(root.getData() + " ");

        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //BFS implementation
    public static void levelOrder(BinaryTree root) {

        if (root == null)
            return;

        System.out.print(root.getData() + " ");

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree target = queue.remove();

            if (target.getLeft() != null) {
                System.out.print(target.getLeft().getData() + " ");
                queue.add(target.getLeft());
            }

            if (target.getRight() != null) {
                System.out.print(target.getRight().getData() + " ");
                queue.add(target.getRight());
            }
        }
    }
}
