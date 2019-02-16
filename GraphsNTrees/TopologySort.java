import java.util.Stack;
import java.util.LinkedList;

class TopologySort
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

        private void topologicalSortingHandler(int start, boolean[] visited, Stack<Integer> stack)
        {
            visited[start] = true;
            for(int adj : adjList[start])
            {
                if(!visited[adj])
                    topologicalSortingHandler(adj, visited, stack);
            }
            stack.push(start);
        }

        public void topologicalSorting()
        {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<vertices; i++)
            {
                if(!visited[i])
                    topologicalSortingHandler(i, visited, stack);
            }

            System.out.println("Topological Sorting");
            int size = stack.size();
            for(int i=0; i<size; i++)
                System.out.print(stack.pop() + "  ");
            
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEgde(7, 6);
        graph.addEgde(7, 5);
        graph.addEgde(6, 4);
        graph.addEgde(6, 3);
        graph.addEgde(5, 4);
        graph.addEgde(5, 2);
        graph.addEgde(3, 1);
        graph.addEgde(2, 1);
        graph.addEgde(1, 0);
        graph.topologicalSorting();
    }
}