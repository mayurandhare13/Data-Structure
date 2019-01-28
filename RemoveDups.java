// remove duplicates inplace

import java.util.Arrays;
class RemoveDups 

{
    public static int removeDuplicates(int[] nums) 
    {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[i])
                continue;
            nums[++i]=nums[j];

            System.out.println(Arrays.toString(nums));
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));

    }
}