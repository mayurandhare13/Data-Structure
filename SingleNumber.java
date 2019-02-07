// find the single number, all other numbers in array are occur twice

import java.util.BitSet;

class SingleNumber {
    public static void singleNumber(int[] nums) 
    {
        BitSet bs = new BitSet(nums.length);
        for(int n : nums)
        {
            if(!bs.get(n-1))
            {
                bs.set(n-1);
            }
            else
                bs.clear(n-1);
            System.out.println(bs);
        }    

        System.out.println(bs.length());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3, 3, 4, 4};
        singleNumber(nums);
    }
}