import java.util.ArrayList;
import java.util.HashMap;

class Graph
{
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateProject(String name)
    {
        if(!map.containsKey(name))
        {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName)
    {
        Project start = getOrCreateProject(startName);
        Project end = getOrCreateProject(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes()
    {
        return this.nodes;
    }
}