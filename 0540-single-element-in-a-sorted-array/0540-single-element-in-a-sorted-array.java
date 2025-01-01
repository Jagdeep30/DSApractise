class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0;
        int n = nums.length;
        int e = n-1;
        while(s<e){
            int mid = s+(e-s)/2;
            boolean even = (mid/2)*2 == mid;
            if(even && mid+1<n && nums[mid+1]!=nums[mid])e = mid;
            else if(!even && mid+1<n && nums[mid+1]==nums[mid])e=mid;
            else s = mid+1;
        }
        return nums[e];
    }
}