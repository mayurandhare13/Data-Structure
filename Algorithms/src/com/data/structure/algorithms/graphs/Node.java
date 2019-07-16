package com.data.structure.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    private List<Node> adjacent;
    private String vertex;
    public SCC.State state;
    
    public Node(String vertex)
    {
        this.vertex = vertex;
        adjacent = new ArrayList<>();
    }

    public String getVertexName() {
        return this.vertex;
    }

    public void addAdjacent(Node x)
    {
        this.adjacent.add(x);
    }

    public List<Node> getAdjacent(){ return this.adjacent;}

    public String getVertex(){ return this.vertex; }
}