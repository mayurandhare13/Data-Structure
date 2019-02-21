// find first positive missing element in array in linear time
class FirstPosMissing
{
    private static int segregate(int[] arr, int size)
    {
        int j=0;
        
        for(int i = 0; i < size; i++)
        {
            if(arr[i] <= 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }

    private static int findMissingPositive(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);
            if(x-1 < size && arr[x-1] > 0)
                arr[x-1] = -arr[x-1];
        }

        // return first index which is positive
        for(int i = 0; i < size; i++)
        {
            if(arr[i] > 0)
                return i+1;
        }
        return size+1;
    }

    public static int findMissing(int[] arr)
    {
        int size = arr.length;
        int index = segregate(arr, size);
        int[] arr2 = new int[size - index];
        int j = 0;
        for(int i = index; i < size; i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        return findMissingPositive(arr2, j);
    }

    public static void main(String[] args) 
    {
        int[] arr = new int[]{-10, -14, 0, 2, 10};    
        int missing = findMissing(arr);
        System.out.println("The smallest positive missing number is: "+missing);
    }
}