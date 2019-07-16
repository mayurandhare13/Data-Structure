package com.data.structure.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph
{
    private List<Node> vertices;
    public int count;

    public Graph()
    {
        vertices = new ArrayList<>();
        count = 0;
    }

    public int getNo_of_vertex() {
        return vertices.size();
    }

    public List<Node> getVertices() {
        return vertices;
    }

    public void addNode(Node x)
    {
        if(count < vertices.size()) {
            vertices.add(x);
        }
        else
            System.out.println("Graph is full.");
    }

    public void addEdge(Node n1, Node n2) {
        if(!vertices.contains(n1))
            vertices.add(n1);
        if(!vertices.contains(n2))
            vertices.add(n2);

        n1.addAdjacent(n2);
    }

    public void DFSUtil(Node v) {
        v.state = SCC.State.Visited;
        System.out.print(v.getVertexName() + " ");

        List<Node> adjacent = v.getAdjacent();
        for(Node n : adjacent) {
            if(n.state == SCC.State.Unvisited) {
                DFSUtil(n);
                System.out.println();
            }
        }
    }
}