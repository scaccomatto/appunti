package com.paru.treesAndGraphs;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;

public class NodeHelper {

    private static Comparator<Node> minDistance = comparing(Node:: getDistance, nullsLast(naturalOrder()));

    public static Node commonAncestorWithParent(Node root, Node target) {

        if (root == target) {
            return null;
        }

        Node anchestor = root;

        while (anchestor != null) {
            if (isOnPath(anchestor, target)) {
                return anchestor;
            }
            anchestor = anchestor.getParent();
        }
        return null;
    }

    private static boolean isOnPath(Node ancestor, Node node) {

        while (node != ancestor && node != null) {
            node = node.getParent();
        }
        return node == ancestor;
    }


    public static void visitBFS(Node root) {

        root.setVisited(true);

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node target = queue.remove();
            System.out.print(target.toString()+" ");

            for (Node adj : target.getAdj()) {

                if (!adj.isVisited()) {
                    adj.setVisited(true);
                    queue.add(adj);
                }
            }
        }
    }

    public static void visitDFS(Node root) {

        if (root == null) {
            return;
        }
        if(!root.isVisited())
            System.out.print(root.toString()+" ");

        root.setVisited(true);

        for (Node adj : root.getAdj()) {
            if (!adj.isVisited()) {
                visitDFS(adj);
            }
        }
    }


    public static void dfsPathsList(Node v, Node d, List<Node> path, List<List<Node>> records) {
        v.setVisited(true);
        path.add(v);

        if (v.equals(d)) {

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
            }
            System.out.println("");
            List<Node> tmp= new ArrayList<>();
            tmp.addAll(path);
            records.add(tmp);
        } else {
            for (Node w: v.getAdj()) {
                if (!w.isVisited()) {
                    dfsPathsList( w, d, path, records);
                }

            }
        }
        path.remove(path.size() - 1);
        v.setVisited(false);
    }

    public static List<Node> shortestPath(Node root, Node target, List<Node> nodes){

        //set up root distance
        root.setDistance(0);

        ArrayList<Node> visited = new ArrayList<>();
        //visited.add(root);
        List<Node> toVisit = new LinkedList<>();

        toVisit.addAll(nodes);

        while(!toVisit.isEmpty()){

            Node node = findMinDistanceNode(toVisit);

            for(Node adj: node.getAdj()){
                updateDistance(node, adj);
            }
            toVisit.remove(node);
            visited.add(node);
        }


        List<Node> shortestPathTarget = new LinkedList<>();

        shortestPathTarget.add(visited.get(visited.indexOf(target)));
        Node temp = shortestPathTarget.get(0);
        System.out.println("target distance ="+temp.getDistance());
        while(temp.getParent()!= null){
            shortestPathTarget.add(0,temp.getParent());
            temp = temp.getParent();
        }
        shortestPathTarget.forEach(n ->System.out.print(n.toString()));
        return shortestPathTarget;
    }

    private static void updateDistance(Node node, Node adj) {
        int newDistance = node.getDistance()+1;
        if(adj.getDistance()>newDistance){
            adj.setDistance(newDistance);
            adj.setParent(node);
        }
    }

    private static Node findMinDistanceNode(List<Node> toVisit) {

        return toVisit.stream().sorted(minDistance).findFirst().get();
    }
}
