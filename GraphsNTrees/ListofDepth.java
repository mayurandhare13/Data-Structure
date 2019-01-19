import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class ListofDepth
{
    private static void createLevelLLdfs(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) 
    {
        if(root == null)
            return;
        LinkedList<TreeNode> list = null;
        if(lists.size() == level)   // level not contained in lists
        {
            list = new LinkedList<>();
            lists.add(list);
        }
        else
            list = lists.get(level);
        
        list.add(root);
        createLevelLLdfs(root.left, lists, level+1);
        createLevelLLdfs(root.right, lists, level+1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLLdfs(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLLdfs(root, lists, 0);

        return lists;
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLLbfs(TreeNode root)
    {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null)
        {
            current.add(root);
        }
        while(current.size() > 0)
        {
            result.add(current);    // add prev level list
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents)
            {
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    public static TreeNode createTreeFromArray(int[] array)
    {
        if(array.length > 0)
        {
            TreeNode root = new TreeNode(array[0]);
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            
            boolean done = false;
            int i=1;
            while(!done)
            {
                TreeNode r = (TreeNode)queue.element();
                if(r.left == null)
                {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                }
                else if(r.right == null)
                {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                }
                else
                {
                    queue.remove();
                }
                if(i == array.length)
                    done = true;
            }
            return root;
        }
        else
            return null;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> results)
    {
        int depth = 0;
        for(LinkedList<TreeNode> entry : results)
        {
            Iterator<TreeNode> itr = entry.listIterator();
            System.out.print("Linked List at depth "+ depth + " :");
            while(itr.hasNext())
            {
                System.out.print(" "+ ((TreeNode)itr.next()).data());
            }
            System.out.println();
            depth++;
        }
    }
    public static void main(String[] args) 
    {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createTreeFromArray(nodes_flattened);

        System.out.println("Using Depth First Search");
        ArrayList<LinkedList<TreeNode>> lists = createLevelLLdfs(root);
        printResult(lists);    
        
        System.out.println("\nUsing Breadth First Search");
        ArrayList<LinkedList<TreeNode>> lists_2 = createLevelLLbfs(root);
		printResult(lists_2);   
    }
}