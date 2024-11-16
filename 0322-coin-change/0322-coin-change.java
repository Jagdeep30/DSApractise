class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        // for(int i=0;i<dp.length;i++){
        Arrays.fill(dp,-1);
        // }
        int ans = solve(amount,coins,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    static int solve(int amount, int[] coins, int[] dp){
        if(amount == 0)return 0;
        if(amount<0)return -1;

        if(dp[amount]!=-1)return dp[amount];
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount>=coins[i]){
                int t = solve(amount-coins[i],coins,dp);
                // int res = dp[amount]==-1?+1:dp[amount];
                if(t!=Integer.MAX_VALUE)t+=1;
                min = Math.min(min,t);
            }
            else break;
        }

        if(min==Integer.MAX_VALUE)dp[amount] = -1;
        return dp[amount] = min;
    }
}