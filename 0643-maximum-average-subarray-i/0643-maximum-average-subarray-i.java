class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int n = nums.length;
        double ans = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        ans = Math.max(ans, sum);
        for(int i=k;i<n;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            ans = Math.max(ans, sum);
        }
        return ans/k;
    }
}