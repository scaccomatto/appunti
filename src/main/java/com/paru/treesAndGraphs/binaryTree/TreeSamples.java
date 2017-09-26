package com.paru.treesAndGraphs.binaryTree;

public class TreeSamples {

    public static void main(String[] args) {

        BinaryTree input = setUpTreeTest();

        System.out.print("in order: ");
        TreeVisits.inOrder(input);
//
        System.out.print("post order: ");
        TreeVisits.postOrder(input);
//
        System.out.print("pre order: ");
        TreeVisits.preOrder(input);

        BinaryTree p = new BinaryTree(9);
        BinaryTree q = new BinaryTree(123);

        //TreePaths.printPath(input, rl);

        //BinaryTree result = BinaryTreeHelper.searchNode(5, input);
        BinaryTree commonAncestor = BinaryTreeHelper.lowestCommonAncestor(input,9,123);
        BinaryTree commonAncestor2 = BinaryTreeHelper.commonAncestor2(input,p,q);

        System.out.println("max= "+BinaryTreeHelper.findMax(input));
        System.out.println("balanced= "+BinaryTreeHelper.isBalanced(input));
        System.out.println("commonAnchestor= "+commonAncestor.getData());
        System.out.println("commonAnchestor2= "+commonAncestor2.getData());
        System.out.println("sqrt= "+Math.sqrt(9.0));


    }

    private static BinaryTree setUpTreeTest() {

        BinaryTree root = new BinaryTree(6);
        root.setNode(4);
        root.setNode(7);
        root.setNode(1);
        root.setNode(16);
        root.setNode(9);
        root.setNode(3);
        root.setNode(5);
        root.setNode(123);
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
