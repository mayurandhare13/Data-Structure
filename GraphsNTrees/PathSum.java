import java.util.HashMap;

class PathSum
{
    private static int countPathsWithSumFromNode(TreeNode node, int target, int currentSum)
    {
        if(node == null)
            return 0;

        currentSum += node.data();

        int totalPaths = 0;
        if(target == currentSum)
            totalPaths++;

        totalPaths += countPathsWithSumFromNode(node.left, target, currentSum); // left
        totalPaths += countPathsWithSumFromNode(node.right, target, currentSum); // right

        return totalPaths;
    }

    public static int countPathsWithSum(TreeNode root, int target)
    {
        if(root == null)   
            return 0;
        
        // count paths from root
        int pathFromRoot = countPathsWithSumFromNode(root, target, 0);

        // try left and right nodes
        int pathsOnLeft = countPathsWithSum(root.left, target);
        int pathsOnRight = countPathsWithSum(root.right, target);

        return pathFromRoot + pathsOnLeft + pathsOnRight;
    }


    // Optimized method
    private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta)
    {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if(newCount == 0)
            hashTable.remove(key);
        else
            hashTable.put(key, newCount);
    }

    public static int tallyPathsWithSum(TreeNode root, int target)
    {
        return tallyPathsWithSum(root, target, 0, new HashMap<Integer, Integer>());
    }

    private static int tallyPathsWithSum(TreeNode node, int target, int runningSum, HashMap<Integer, Integer> pathCount)
    {
        if(node == null)
            return 0;   // base case

        runningSum += node.data();

        // count paths with sum ending with target
        int sum = runningSum - target;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        // if runningSum == target, this is additional path
        if(runningSum == target)
            totalPaths++;
        
        // add runningSum to pathCount
        incrementHashTable(pathCount, runningSum, 1);

        // count paths on left and right subtree
        totalPaths += tallyPathsWithSum(node.left, target, runningSum, pathCount);
        totalPaths += tallyPathsWithSum(node.right, target, runningSum, pathCount);

        // remove runningSum
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(2);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(2);
		root.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
        System.out.println(countPathsWithSum(root, 4));    
        
        System.out.println("Optimize method");
        System.out.println(tallyPathsWithSum(root, 0));
		System.out.println(tallyPathsWithSum(root, 4));    
    }
}