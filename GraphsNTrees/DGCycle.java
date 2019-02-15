import java.util.LinkedList;

class DGCycle
{
    static class Graph 
    {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) 
        {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) 
            {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEgde(int source, int destination) 
        {
            adjList[source].addFirst(destination);
        }

        private boolean isCycleUtil(int vertex, boolean[] Visited, boolean[] recursArr)
        {
            Visited[vertex] = true;
            recursArr[vertex] = true;

            for(int adjVertex : adjList[vertex])
            {
                if(!Visited[adjVertex] && isCycleUtil(adjVertex, Visited, recursArr))
                    return true;
                else if(recursArr[adjVertex])
                    return true;
            }
            recursArr[vertex] = false;
            return false;
        }


        public boolean isCycle()
        {
            boolean Visited[] = new boolean[vertices];
            boolean recursArr[] = new boolean[vertices];

            // do DFS from each node
            for(int i=0; i<vertices; i++)
            {
                if(isCycleUtil(i, Visited, recursArr))
                    return true;
            }
            return false;
        }

    }
        public static void main(String[] args) 
        {
            int vertices = 4;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1);
            graph.addEgde(1, 2);
            graph.addEgde(2, 3);
            graph.addEgde(3, 3);
            boolean result = graph.isCycle();
            System.out.println("is Cycle present: " + result);
        }
}
