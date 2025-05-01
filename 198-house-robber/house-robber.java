class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }

    static int solve(int i, int[] nums, int[] dp){
        //base case
        if(i>=nums.length)return 0;
        if(i==nums.length-1)return nums[i];

        if(dp[i]!=-1)return dp[i];

        // //choose
        // solve(i+2,nums,dp) + nums[i];
        // //not choose
        // solve(i+1,nums,dp);

        //return answer
        return dp[i] = Math.max(solve(i+2,nums,dp)+nums[i], solve(i+1,nums,dp));
    }
}