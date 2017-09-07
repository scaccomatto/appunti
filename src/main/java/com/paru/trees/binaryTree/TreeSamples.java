package com.paru.trees.binaryTree;

public class TreeSamples {

    public static void main(String[] args) {

        BinaryTree input = setUpTreeTest();

        System.out.print("in order: ");
        TreeVisits.inOrder(input);
//
//        System.out.print("post order: ");
//        TreeVisits.postOrder(input);
//
//        System.out.print("pre order: ");
//        TreeVisits.preOrder(input);

        BinaryTree rl = new BinaryTree(3);

        //TreePaths.printPath(input, rl);

        //BinaryTree result = BinaryTreeHelper.searchNode(5, input);


        System.out.println("max= "+BinaryTreeHelper.findMax(input));


    }

    private static BinaryTree setUpTreeTest() {

        BinaryTree root = new BinaryTree(2);
        root.setNode(1);
        root.setNode(4);
        root.setNode(7);
        root.setNode(123);
        root.setNode(9);
        root.setNode(3);
        root.setNode(5);
        root.setNode(6);
        //BinaryTree l = new BinaryTree(1);
        //BinaryTree r = new BinaryTree(4);
//
//        root.setLeft(l);
//        root.setRight(r);
//
//        BinaryTree rl = new BinaryTree(3);
//        BinaryTree rr = new BinaryTree(5);
//
//        r.setLeft(rl);
//        r.setRight(rr);

        return root;

    }


}
