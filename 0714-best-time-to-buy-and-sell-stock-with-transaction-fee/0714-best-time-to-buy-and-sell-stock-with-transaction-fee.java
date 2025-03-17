class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        return solve(0,true,prices,fee,dp);
    }

    static int solve(int i, boolean buy, int[] prices, int fee, int[][] dp){
        //base case
        if(i==prices.length)return 0;

        if(dp[i][buy?1:0]!=0)return dp[i][buy?1:0];

        //choices
            int res = solve(i+1,!buy,prices,fee,dp);
            //buy
            if(buy)res = res - prices[i] - fee;
            //sell
            if(!buy)res = res + prices[i];
            //not sell || not buy
            res = Math.max(res,solve(i+1,buy,prices,fee,dp));

        //max
        return dp[i][buy?1:0] = res;
    }
}