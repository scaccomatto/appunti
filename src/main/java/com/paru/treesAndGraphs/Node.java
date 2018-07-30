package com.paru.treesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class Node {

    private int data;
    private List<Node> adj;
    private Node parent;
    private boolean visited;
    private int distance;


    public Node(int data) {
        this.data = data;
        adj = new LinkedList<>();
        this.distance = Integer.MAX_VALUE;
    }

    public int getData() {
        return data;
    }

    public List<Node> getAdj() {
        return adj;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addAdjacent(Node child) {
        adj.add(child);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Node{" +
                data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return getData() == node.getData();
    }

    @Override
    public int hashCode() {
        return getData();
    }
}
