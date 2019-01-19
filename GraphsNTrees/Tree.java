import java.util.Random;

class Tree
{
    TreeNode root = null;

    public int size()
    {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode()
    {
        Random random = new Random();
        int index = random.nextInt(size());
    
        return root.getIthNode(index);
    }

    public void insertInOrder(int value)
    {
        if(root == null)
            root = new TreeNode(value);
        else
            root.insertInOrder(value);
    }
}