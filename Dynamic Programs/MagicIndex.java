// find magic index where a[i] == i
class MagicIndex
{
    public static int findMagic(int[] arr)
    {
        return findMagic(arr, 0, arr.length - 1);
    }

    private static int findMagic(int[] arr, int start, int end)
    {
        if(end < start)
            return -1;
        
        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];
        if(midIndex == midValue)
            return midIndex;

        // search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = findMagic(arr, start, leftIndex);
        if(left > 0)
            return left;

        // search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = findMagic(arr, rightIndex, end);
        
        return right;
    }

    public static void main(String[] args) 
    {
        int[] arr = {-10, -5, -1, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(findMagic(arr));    
    }
}