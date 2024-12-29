class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = Math.min(nums[0],nums[n-1]);
        int s = 0;
        int e = n-1;
        while(s<e){
            int mid = s + (e-s) / 2;
            if(nums[mid]>nums[e]){
                s = mid + 1;
            }
            else if (nums[mid]<nums[s]){
                s = s + 1;
                e = mid;
            }
            else{
                e--;
            }
        }
        // if(s==e)ans = Math.min(ans,nums[s]);
        return nums[s];
    }
}