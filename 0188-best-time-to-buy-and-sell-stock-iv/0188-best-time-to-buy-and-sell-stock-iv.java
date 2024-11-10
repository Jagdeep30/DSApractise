class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],Integer.MIN_VALUE);
        return solve(0,0,prices,dp,k);
    }

    static int solve(int i, int act, int[] prices, int[][] dp, int k){
        if(i==prices.length)return 0;
        if(act==2*k)return 0;

        if(dp[i][act]!=Integer.MIN_VALUE)return dp[i][act];

        int max = Integer.MIN_VALUE;
        if(act%2==0){
            //buy
            max = Math.max(max,Math.max(solve(i+1,act+1,prices,dp,k)-prices[i],solve(i+1,act,prices,dp,k)));
        }
        else{
            //sell
            int t = solve(i+1,act+1,prices,dp,k);
            if(t!=Integer.MIN_VALUE)t+=prices[i];
            max = Math.max(max,Math.max(t,solve(i+1,act,prices,dp,k)));
        }

        return dp[i][act] = max;
    }
}