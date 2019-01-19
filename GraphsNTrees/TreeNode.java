import java.util.Random;

class TreeNode
{
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d)
    {
        data = d;
        size = 1;
    }

    public int size() { return this.size; }
    
    public int data() { return this.data; }
        
    public void insertInOrder(int d)
    {
        if(d <= data)
        {
            if(left == null)
                left = new TreeNode(d);
            else
                left.insertInOrder(d);
        }
        else
        {
            if(right == null)
                right = new TreeNode(d);
            else
                right.insertInOrder(d);
        }
        size++;
    }
    
    public TreeNode find(int d)
    {
        if(d == this.data)
            return this;
        else if(d <= this.data)
            return left != null ? left.find(d) : null;
        else if(d > this.data)
            return right != null ? right.find(d) : null;
        
        return null;
    }

    public TreeNode getRandomNode()
    {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);

        if(index < leftSize)
            return left.getRandomNode();
        else if(index == leftSize)
            return this;
        else
            return right.getRandomNode();
    }

    public TreeNode getIthNode(int i)
    {
        int leftSize = left == null ? 0 : left.size();
        if(i < leftSize)
            return left.getIthNode(i);
        else if(i == leftSize)
            return this;
        else
            return right.getIthNode(i - (leftSize + 1));
    }
}