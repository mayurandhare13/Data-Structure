import java.util.ArrayList;

public class Topology
{
    public static Graph buildGraph(String[] projects, String[][] dependencies)
    {
        Graph g = new Graph();
        for(String project : projects)
        {
            Project tmp = g.getOrCreateProject(project);
        }

        for(String[] dependency : dependencies)
        {
            String first = dependency[0];
            String sec = dependency[1];
            g.addEdge(first, sec);
        }
        return g;
    }

    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset)
    {
        for(Project project : projects)
        {
            if(project.getNumberOfDependencies() == 0)
            {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    public static Project[] orderProjects(ArrayList<Project> projects)
    {
        Project[] order = new Project[projects.size()];

        // add roots to build order first
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while(toBeProcessed < order.length)
        {
            Project current = order[toBeProcessed];

            // we have circular dependencies, as there are no remaining projects with 0 dependencies
            if(current == null)
                return null;
            
            ArrayList<Project> children = current.getChildren();
            for(Project child : children)
            {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }
        return order;
    }

    public static String[] convertToStringList(Project[] projects)
    {
        String[] buildOrder = new String[projects.length];

        for(int i=0; i<projects.length; i++)
        {
            buildOrder[i] = projects[i].getName();
        }
        return buildOrder;
    }

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies)
    {
        Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
    }

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies)
    {
        Project[] buildOrder = findBuildOrder(projects, dependencies);

        if(buildOrder == null)  return null;

        String[] buildOrderString = convertToStringList(buildOrder);

        return buildOrderString;
    }

    public static void main(String[] args) 
    {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
        
        String[] buildOrder = buildOrderWrapper(projects, dependencies);

		if (buildOrder == null)
			System.out.println("Circular Dependency.");
		else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}
	}
}