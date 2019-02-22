class ShortestBridge
{
    public static int shortestBridge(int[][] A) 
    {
        int len = A.length;
        int[] shortB = new int[len];
        for(int i=0; i<len; i++)
        {
            for(int j=0; j<len; j++)
            {
                if(A[i][j] == 1)
                {
                    shortB[i] += 1;
                    if(shortB[i] == len)
                        return 1;
                }
            }
        }
        int max = 1;
        for(int m : shortB)
        {
            System.out.println(m);
            if(max < m)
                max = m;
        }
        return len-max;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("output -->" + shortestBridge(A));
    }
}