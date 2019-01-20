class Successor
{
    public static TreeNode inorderSucc(TreeNode n)
    {
        if(n == null) return null;

        if(n.right != null)
            return leftMostChild(n.right);
        else
        {
            TreeNode q = n;
            TreeNode x = q.parent;

            // go up until we are on left instead of right
            while(x != null && x.left != q)
            {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode n)
    {
        while(n.left != null)
            n = n.left;
        
        return n;
    }

    public static void main(String[] args) 
    {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) 
        {
			TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            
            if (next != null) 
				System.out.println(node.data() + "->" + next.data());
			else
				System.out.println(node.data() + "->" + null);
		}
	}
}