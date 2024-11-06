class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return solve(0,nums,-1,dp);
    }

    static int solve(int i, int[] nums, int prev, int[][] dp){
        if(i==nums.length)return 0;

        if(prev != -1 && dp[i][prev]!=-1)return dp[i][prev];

        int max = 0;
        //inc
        if(prev==-1 || nums[i]>nums[prev])max = Math.max(max,solve(i+1,nums,i,dp)+1);
        //exc
        max = Math.max(max,solve(i+1,nums,prev,dp));

        if(prev!=-1)return dp[i][prev] = max;
        return max;
    }
}