// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

class ExceptProduct
{
    public static int[] findProduct(int[] arr)
    {
        int product = 1;
        for(int i : arr)
            product *= i;
        
        for(int i=0; i< arr.length; i++)
        {
            arr[i] = product / arr[i];
        }
        return arr;
    }

    public static void main(String[] args) 
    {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] prod = findProduct(arr);
        for(int i : prod)
            System.out.print(i + " ");    
    }
}