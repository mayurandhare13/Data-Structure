import java.util.Queue;
import java.util.LinkedList;

class SubTree
{
    public static boolean containsTree(TreeNode t1, TreeNode t2)
    {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        System.out.println(string1);
        System.out.println(string2);


        return string1.indexOf(string2.toString()) != -1;
    }

    private static void getOrderString(TreeNode node, StringBuilder sb)
    {
        if(node == null)
        {
            sb.append("X");
            return;
        }

        sb.append(node.data());
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
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

// Method 2

    private static boolean matchTree(TreeNode r1, TreeNode r2)
    {
        if(r1 == null && r2 == null)
            return true; // both trees are empty
        else if(r1 == null || r2 == null)
            return false; // one of the tree is empty
        else if(r1.data() != r2.data())
            return false;
        else
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }

    private static boolean isSubTreeHandler(TreeNode r1, TreeNode r2)
    {
        if(r1 == null)
            return false; // as big tree is empty and subtree isn't found
        else if(r1.data() == r2.data() && matchTree(r1, r2))
            return true;
        else
            return isSubTreeHandler(r1.left, r2) || isSubTreeHandler(r1.right, r2);
    }

    public static boolean isSubTree(TreeNode t1, TreeNode t2)
    {
        if(t2 == null)
            return true;
        
        return isSubTreeHandler(t1, t2);  
    }


    public static void main(String[] args) 
    {

        System.out.println("METHOD 1");

		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = createTreeFromArray(array1);
		TreeNode t2 = createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t4 = createTreeFromArray(array3);

		if (containsTree(t1, t4)) {
			System.out.println("t4 is a subtree of t1");
		} else {
			System.out.println("t4 is not a subtree of t1");
        }
        

        // method 2
        System.out.println("METHOD 2");
        if (isSubTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		if (isSubTree(t1, t4)) {
			System.out.println("t4 is a subtree of t1");
		} else {
			System.out.println("t4 is not a subtree of t1");
        }
	}
}