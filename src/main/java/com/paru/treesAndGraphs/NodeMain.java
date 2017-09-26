package com.paru.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodeMain {
    private static List<Node> toTest= new LinkedList<>();

    public static void main(String[] args){

        Node root = setUp();

        Node d = new Node(7);
        List<Node> path = new ArrayList<>();
        List<List<Node>> records = new ArrayList<List<Node>>();

        //NodeHelper.visitDFS(root);
        //NodeHelper.visitBFS(root);
        NodeHelper.dfsPathsList(root, d, path, records);
        for(List<Node> l : records){
            l.forEach(p -> System.out.print(p.toString()));
            System.out.println();
        }
        root = setUp();
        NodeHelper.shortestPath(root,d,toTest);

    }

    private static Node setUp(){

        Node root = new Node(1);
        Node due = new Node(2);
        Node tre = new Node(3);
        Node quattro = new Node(4);
        Node cinque = new Node(5);
        Node sei = new Node(6);
        Node sette = new Node(7);

        root.addAdjacent(due);
        root.addAdjacent(tre);

        due.addAdjacent(tre);
        due.addAdjacent(quattro);
        due.addAdjacent(cinque);
        due.addAdjacent(root);

        tre.addAdjacent(due);
        tre.addAdjacent(root);
        tre.addAdjacent(quattro);

        quattro.addAdjacent(due);
        quattro.addAdjacent(tre);
        quattro.addAdjacent(sei);

        cinque.addAdjacent(due);
        cinque.addAdjacent(sei);

        sei.addAdjacent(cinque);
        sei.addAdjacent(quattro);
        sei.addAdjacent(sette);

        toTest.add(root);
        toTest.add(due);
        toTest.add(tre);
        toTest.add(quattro);
        toTest.add(cinque);
        toTest.add(sei);
        toTest.add(sette);

        return root;
    }
}
