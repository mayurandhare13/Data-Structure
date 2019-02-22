import java.util.HashSet;
import java.util.Set;

class ArraySum
{
    public static void printPairs(int[] arr, int n)
    {
        if(arr.length < 2)
            return;

        Set set = new HashSet(arr.length);

        for(int number : arr)
        {
            int target = n - number;
            if(!set.contains(target))
                set.add(number);
            else
                System.out.printf("(%d, %d) %n", number, target);
        }
    }



    public static void main(String[] args) 
    {
        int[] numbers = new int[]{0, 14, 0, 4, 7, 8, 3, 5, 7};
        printPairs(numbers, 13);
    }
    
}