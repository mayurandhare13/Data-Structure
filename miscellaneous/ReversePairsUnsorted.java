// Find Number of reverse pairs in an array
class ReversePairsUnsorted
{
    static int reversePairs = 0;

    public void findPairs(int[] A, int start, int end)
    {
        if(start >= end)
            return;

        int mid = start + (end-start)/2;
        findPairs(A, start, mid);
        findPairs(A, mid+1, end);
        
        sortAndConquer(A, start, mid, end);
    }

    private void sortAndConquer(int[] A, int left, int mid, int right)
    {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] Left = new int[len1];
        int[] Right = new int[len2];

        for(int i=0; i<len1; i++)
            Left[i] = A[left+i];
        
        for(int j=0; j<len2; j++)
            Right[j] = A[mid+1+j];

        reversePairs += findPairsUtils(Left, Right);

        int index = left;
        int i=0, j=0;
        while(i<len1 && j<len2)
        {
            if(Left[i] <= Right[j])
            {
                A[index] = Left[i];
                i++;
            }
            else
            {
                A[index] = Right[j];
                j++;
            }
            index++;
        }

        while(i < len1)
        {
            A[index] = Left[i];
            i++;
            index++;
        }

        while(j < len2)
        {
            A[index] = Right[j];
            j++;
            index++;
        }
    }

    private int findPairsUtils(int[] Left, int[] Right)
    {
        int result = 0;
        int start_part1 = 0;
        int end_part1 = Left.length - 1;

        int start_part2 = 0;
        int end_part2 = Right.length - 1;

        int i = start_part1;
        int j = start_part2;

        while(i <= end_part1 && j <= end_part2)
        {
            if(Left[i] > Right[j])
            {
                result += end_part1 + 1 - i;
                j++;
            }
            else
                i++;
        }
        return result;
    }
    public static void main(String[] args) 
    {
        int A[] = {10, 3, 4, 2, 5, 7, 9, 11};
        new ReversePairsUnsorted().findPairs(A, 0, A.length-1);
        System.out.println("No of reversed pair: " + reversePairs);    
    }
}