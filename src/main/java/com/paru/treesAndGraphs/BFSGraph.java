package com.paru.treesAndGraphs;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFSGraph {

    public static void search(Node origin) {

        Queue queue = new ConcurrentLinkedQueue();
       // origin.visited = true;
        visit(origin);
       // origin.distance = 0;

        queue.add(origin);

//        while (!queue.isEmpty()) {
//            Node r = (Node) queue.remove();
//
//            for (Node n : r.adjacent) {
//                if(!n.visited){
//                    n.distance= r.distance +1;
//                    visit(n);
//                    n.visited = true;
//                    queue.add(n);
//                }
//
//            }
//
//        }
    }

    public static void visit(Node origin) {
        System.out.println(origin.getData());
    }
}

