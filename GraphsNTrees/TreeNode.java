import java.util.Random;

class TreeNode
{
    private int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d)
    {
        data = d;
        size = 1;
    }

    public int size() { return this.size; }
    
    public int data() { return this.data; }

    public void setValue(int v) { this.data = v; }

    private void setLeftChild(TreeNode left)
    {
        this.left = left;
        if(left != null)
            left.parent = this;
    }

    private void setRightChild(TreeNode right)
    {
        this.right = right;
        if(right != null)
            right.parent = this;
    }
        
    public void insertInOrder(int d)
    {
        if(d <= data)
        {
            if(left == null)
                setLeftChild(new TreeNode(d));
            else
                left.insertInOrder(d);
        }
        else
        {
            if(right == null)
                setRightChild(new TreeNode(d));
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

    public static TreeNode createMinimalBST(int[] arr)
    {
        return createMinimalBST(arr, 0, arr.length-1);
    }

    private static TreeNode createMinimalBST(int[] arr, int start, int end)
    {
        if(end < start)
            return null;
        
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid-1);
        n.right = createMinimalBST(arr, mid+1, end);

        return n;
    }

    public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		// System.out.println("Created BST? " + root.isBST());
		// System.out.println("Height: " + root.height());
	}
}