package com.paru.treesAndGraphs;


import java.util.List;

public class DFSGraph {

    public void search(Node origin, List<Node> visited) {
        if (origin == null) {
            return;
        }

        visit(origin);
        origin.setVisited(true);
        visited.add(origin);
        for(Node r : origin.getAdj()){
            if(!visited.contains(r)){
                search(r, visited);
            }
        }
    }

    public void visit(Node v){
        System.out.println(v.getData());
    }
}
