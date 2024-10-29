class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid == 0 && nums[mid]>nums[mid+1] || (mid == nums.length-1 && nums[mid]>nums[mid-1]))return mid;
            else if(mid == 0)s = mid+1;
            else if(mid == nums.length-1)e = mid;
            else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])return mid;
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1])s = mid+1;
            else e = mid;
        }
        return -1;
    }
}