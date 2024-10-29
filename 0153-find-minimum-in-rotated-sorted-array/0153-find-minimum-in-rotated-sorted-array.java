class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(nums[mid]>=nums[0])s = mid+1;
            else e = mid;
        }
        return nums[0]<nums[e]?nums[0]:nums[e];
    }
}