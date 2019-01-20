// find common ancestor

class Ancestor
{
    public static class Result
    {
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode node, boolean isAnc)
        {
            this.node = node;
            this.isAncestor = isAnc;
        }
    }

    private static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, String s)
    {
        if(root == null)
            {
              //  System.out.println("\t"+ s + " NULL");
                return new Result(null, false);
            }
        
        //System.out.println(s + root.data());

        if(root == p  && root == q)
            return new Result(root, true);

        Result Rx = commonAncestorHelper(root.left, p, q, "LEFT: ");
        if(Rx.isAncestor)
            return Rx;

        Result Ry = commonAncestorHelper(root.right, p, q, "RIGHT: ");
        if(Ry.isAncestor)
            return Ry;

        if(Rx.node != null && Ry.node != null)
            return new Result(root, true);  // this is the common ancestor
        else if(root == p || root == q)
        {
            boolean isAncestor = Rx.node != null || Ry.node != null;
            //System.out.println("\t\t"+root.data()+"  "+isAncestor);
            return new Result(root, isAncestor);
        }
        else
            return new Result(Rx.node != null ? Rx.node : Ry.node, false);
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        Result r = commonAncestorHelper(root, p, q, "root ");
        if(r.isAncestor)
            return r.node;
        return null;
    }

    public static void main(String[] args) 
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n1 = root.find(2);
        TreeNode n2 = root.find(6);

        TreeNode ancestor = commonAncestor(root, n1, n2);
        if(ancestor != null)
            System.out.println(ancestor.data());
        else
            System.out.println("null");
    }
}