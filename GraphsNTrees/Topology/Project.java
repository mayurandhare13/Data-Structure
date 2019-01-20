import java.util.ArrayList;
import java.util.HashMap;

class Project
{
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n)
    {
        this.name = n;
    }

    public String getName()
    {
        return this.name;
    }

    public void addNeighbor(Project node)
    {
        if(!map.containsKey(node.getName()))
        {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependecies();
        }
    }

    public ArrayList<Project> getChildren()
    {
        return children;
    }

    public void incrementDependecies()
    {
        this.dependencies++;
    }

    public void decrementDependencies()
    {
        this.dependencies--;
    }

    public int getNumberOfDependencies()
    {
        return this.dependencies;
    }
}