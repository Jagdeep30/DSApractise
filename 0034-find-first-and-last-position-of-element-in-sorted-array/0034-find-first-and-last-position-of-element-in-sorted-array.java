class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int sp = -1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==target){
                sp = mid;
                e = mid-1;
            }
            else if(target>nums[mid])s = mid+1;
            else e = mid-1;
        }
        s = 0;
        e = nums.length-1;
        int ep = -1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==target){
                ep = mid;
                s = mid+1;
            }
            else if(target>nums[mid])s = mid+1;
            else e = mid-1;
        }
        return new int[]{sp,ep};
    }
}