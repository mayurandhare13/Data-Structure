// find the single number, all other numbers in array are occur twice

import java.util.BitSet;

class SingleNumber {
    public static void singleNumber(int[] nums) 
    {
        int n = 0;
        for(int i : nums)
        {
            n ^= i;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3, 3, 4, 4};
        singleNumber(nums);
    }
}