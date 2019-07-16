package com.data.structure.algorithms.graphs;

import java.util.List;
import java.util.Stack;

public class SCC {
    public enum State {Visited, Unvisited}

    // invert the direction of graph
    private Graph getTranspose(Graph g) {
        Graph gr = new Graph();
        List<Node> vertices = g.getVertices();
        for(int v = 0; v < g.getNo_of_vertex(); v++) {
            Node node = vertices.get(v);
            for(Node n : node.getAdjacent())
                gr.addEdge(n, node);
        }

        return gr;
    }

    private void fillOrder(Node v, Stack<Node> stack) {
        v.state = State.Visited;

        List<Node> adjacents = v.getAdjacent();
        for(Node n : adjacents) {
            if(n.state == State.Unvisited)
                fillOrder(n, stack);
        }
        stack.push(v);
    }

    private void printSCC(Graph g) {
        Stack<Node> stack = new Stack<>();

        List<Node> gVertices = g.getVertices();
        for(int i = 0; i < g.getNo_of_vertex(); i++)
            gVertices.get(i).state = State.Unvisited;

        for(int i = 0; i < g.getNo_of_vertex(); i++) {
            if(gVertices.get(i).state == State.Unvisited)
                fillOrder(gVertices.get(i), stack);
        }

        // create reverse graph
        Graph gr = getTranspose(g);

        List<Node> vertices = gr.getVertices();
        for(int i = 0; i < gr.getNo_of_vertex(); i++)
            vertices.get(i).state = State.Unvisited;

        // Now process all vertices in order defined by Stack
        while (!stack.empty())
        {
            // Pop a vertex from stack
            Node v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (v.state == State.Unvisited)
            {
                gr.DFSUtil(v);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");

        // Create a graph given in the above diagram
        Graph g = new Graph();

        g.addEdge(node1, node2);
        g.addEdge(node2, node3);
        g.addEdge(node3, node1);
        g.addEdge(node1, node4);
        g.addEdge(node4, node5);
        g.addEdge(node5, node6);
        g.addEdge(node6, node4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        SCC s = new SCC();
        s.printSCC(g);
    }

}
