// check the validity of bst
class ValidBST
{
    public static boolean checkBST(TreeNode n, Integer min, Integer max)
    {
        if(n == null) return true;

        if((min != null && n.data() <= min) || (max != null && max < n.data()) )
            return false;

        if(!checkBST(n.left, min, n.data()) || !checkBST(n.right, n.data(), max))
            return false;

        return true;
    }

    public static boolean checkBST(TreeNode n)
    {
        return checkBST(n, null, null);
    }

    public static void main(String[] args) 
    {    
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode root = TreeNode.createMinimalBST(array);
 
        System.out.println(checkBST(root));
        
        root.left.setValue(33);
        System.out.println(checkBST(root));
    }
}