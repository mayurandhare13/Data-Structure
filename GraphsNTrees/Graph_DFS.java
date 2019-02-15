import java.util.LinkedList;
import java.util.Stack;

class Graph_DFS
{
    int vertex;
    LinkedList<Integer> list[];

    Graph_DFS(int vertex)
    {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for(int i = 0; i < vertex ; i++)
            list[i] = new LinkedList<>();
    }

    public void addEdge(int source, int dest)
    {
        list[source].addFirst(dest);
    }

    public void DFS()
    {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        System.out.println("Depth First Search");

        visited[0] = true;
        stack.push(0);
        while(!stack.isEmpty())
        {
            System.out.println("in stack now: "+stack.toString() );  
            int nodeIndex = stack.pop();
            System.out.println(nodeIndex+ "\n");
    
            for(int n : list[nodeIndex])
            {
                if(!visited[n])
                {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(nodeList.isEmpty()==false) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        Graph_DFS graph = new Graph_DFS(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 2);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 6);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        
        graph.printGraph();
        graph.DFS();    
    }
}