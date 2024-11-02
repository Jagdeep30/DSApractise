class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(s<e){
            int mid = s+(e-s)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]<target)s = mid+1;
            else e = mid;
        }
        // System.out.println(s+"  "+e);
        if(s==e && nums[s]==target)return s;
        else if(s==e && nums[s]<target)return s+1;
        else if(s==e && nums[s]>target)return s;
        else if(target<nums[0])return 0;
        else if(target>nums[nums.length-1])return nums.length;
        return -1;
    }
}