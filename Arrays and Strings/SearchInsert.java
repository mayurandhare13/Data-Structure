// https://leetcode.com/problems/search-insert-position/

class SearchInsert
{
    public static int searchInsert(int[] nums, int target) 
    {
        int l = 0, r = nums.length-1;
        int mid=0;
        while(l <= r)
        {
            mid = l + (r - l) / 2;
            System.out.println(l + " "+ r + " "+mid);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid+1;
            else 
                r = mid-1;
        }
        return l;
    }

    public static void main(String[] args) 
    {
        int[] arr = new int[]{1,3,5,8};
        System.out.println(searchInsert(arr, 0));
    }
}