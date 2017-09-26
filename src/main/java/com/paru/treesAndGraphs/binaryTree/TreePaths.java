package com.paru.treesAndGraphs.binaryTree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePaths {

    public static void printPath(BinaryTree root, BinaryTree target) {

        List<BinaryTree> path = findPath(root, target);

        path.forEach(t -> System.out.println(t.getData()));
    }

    private static List<BinaryTree> findPath(BinaryTree root, BinaryTree target) {

        if (root == null)
            return null;

        if (root.equals(target)) {
            List<BinaryTree> path = new LinkedList<BinaryTree>();//
            path.add(root);
            return path;
        }
        Queue<BinaryTree> q = new LinkedList();

        List<BinaryTree> pathLeft = findPath(root.getLeft(), target);
        List<BinaryTree> pathRight = findPath(root.getRight(), target);

        if (pathLeft != null) {
            pathLeft.add(0, root);
            return pathLeft;
        }

        if (pathRight != null) {
            pathRight.add(0, root);
            return pathRight;
        }

        return null;
    }
}
