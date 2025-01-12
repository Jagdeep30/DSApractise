class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length];
        // for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        // return solve(0,nums,-1,dp);

        int[] temp = new int[nums.length];
        int size = 0;
        for(int i=0;i<nums.length;i++){
            int ind = binaryS(temp, size, nums[i]);
            if(ind == size)size++;
        }
        return size;
    }
    static int binaryS(int[] temp, int size, int target){
        int s = 0;
        int e = size;
        while(s<e){
            int mid = s+(e-s)/2;
            if(temp[mid]>=target)e = mid;
            else s = mid + 1;
        }
        temp[e] = target;
        return e;
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