class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);

        int[] temp = new int[nums.length-1];
        int[] temp2 = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)temp[i] = nums[i];
        for(int i=1;i<nums.length;i++)temp2[i-1] = nums[i];

        int res1 = solve(0,temp,dp);
        // Arrays.fill(dp,-1);
        int res2 = solve(0,temp2,dp2);

        return Math.max(res1,res2);
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