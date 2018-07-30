package com.paru.treesAndGraphs.binaryTree;

public class BinaryTreeHelper {

    static BinaryTree lowestCommonAncestor(BinaryTree root, int v1, int v2) {

        if (root == null)
            return null;


        if (v1 > root.getData() && v2 > root.getData()) {
            return lowestCommonAncestor(root.getRight(), v1, v2);
        }

        if (v1 < root.getData() && v2 < root.getData()) {
            return lowestCommonAncestor(root.getLeft(), v1, v2);
        }
        return root;
    }

    public static BinaryTree searchNode(int data, BinaryTree tree) {

        if (tree == null)
            return null;

        if (tree.getData() == data) {
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

    public static Integer findMax(BinaryTree tree) {

        if (tree == null)
            return Integer.MIN_VALUE;

        int result = tree.getData();
        int lMax = findMax(tree.getLeft());
        int rMax = findMax(tree.getRight());

        if (lMax > result) {
            result = lMax;
        }
        if (rMax > result) {
            result = rMax;
        }
        return result;
    }

    public static int getHeight(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        return Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight())) + 1;
    }

    //O(n Long n)
    public static boolean isBalanced(BinaryTree tree) {
        if (tree == null)
            return true;

        int heightDiff = Math.abs(getHeight(tree.getLeft()) - getHeight(tree.getRight()));

        if (heightDiff > 1) {
            return false;
        } else {
            return isBalanced(tree.getLeft()) && isBalanced(tree.getRight());
        }
    }

    public static int checkHeight(BinaryTree tree) {
        if (tree == null)
            return 0;

        int leftHeight = checkHeight(tree.getLeft());
        if (leftHeight == -1) {
            return -1;//not balanced
        }

        int rightHeight = checkHeight(tree.getRight());
        if (rightHeight == -1) {
            return -1;//not balanced
        }

        //check current node is balanced
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // O(N)
    public static boolean isBalanced2(BinaryTree tree) {
        if (checkHeight(tree) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static BinaryTree commonAncestor2(BinaryTree tree, BinaryTree p, BinaryTree q) {
        if (!covers(tree, p) || !covers(tree, q)) {
            return null;
        }
        return ancestorHelper(tree, p, q);

    }

    private static BinaryTree ancestorHelper(BinaryTree tree, BinaryTree p, BinaryTree q) {
        if (tree == null) {
            return null;
        } else if (tree.equals(p)) {
            return p;
        } else if (tree.equals(q)) {
            return q;
        }

        boolean pIsOnLeft = covers(tree.getLeft(), p);
        boolean qIsOnLeft = covers(tree.getLeft(), q);

        if (pIsOnLeft != qIsOnLeft) {
            return tree;
        }

        BinaryTree subTree = pIsOnLeft ? tree.getLeft() : tree.getRight();

        return ancestorHelper(subTree, p, q);


    }

    private static boolean covers(BinaryTree tree, BinaryTree p) {
        if (tree == null) return false;
        if (tree.equals(p)) return true;
        return covers(tree.getLeft(), p) || covers(tree.getRight(), p);
    }

}
