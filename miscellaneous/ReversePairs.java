// Find no of reverse pairs in an array which is sorted in two parts in O(N)

class ReversePairs
{
    public static void findPairs(int[] A)
    {
        int m = 0;
        for(int i=0; i<A.length; i++)
        {
            if(A[i] > A[i+1])
            {
                m = i+1;
                break;
            }
        }

        int res = 0;
        int start_part1 = 0;
        int end_part1 = m-1;

        int start_part2 = m;
        int end_part2 = A.length-1;

        int i = start_part1;
        int j = start_part2;
        while(i <= end_part1 && j <= end_part2)
        {
            if(A[i] > A[j])
            {
                res += end_part1 + 1 - i;
                j++;
            }
            else
                i++;
        }
        System.out.println("# of reverse pairs: "+res);
    }
    public static void main(String[] args) 
    {
        int[] A = {4, 6, 8, 9, 0, 1, 2, 5, 10, 11};
        findPairs(A);    
    }
}