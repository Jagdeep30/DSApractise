class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][5];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,4,prices,dp);
    }

    static int solve(int i, int buy, int[] prices,int[][] dp){
        //base case
        if(buy==0 || i==prices.length)return 0;

        if(dp[i][buy]!=-1)return dp[i][buy];
        //explore all the paths

        //buy
        if(buy==4 || buy==2){
            //buy stock
            int b = solve(i+1,buy-1,prices,dp) - prices[i];
            //didn't buy stock
            int nb = solve(i+1,buy,prices,dp);

            return dp[i][buy]=Math.max(b,nb);

        } // sell
        else{
            
            //sell stock
            int s = solve(i+1,buy-1,prices,dp) + prices[i];
            //didn't sell stock
            int ns = solve(i+1,buy,prices,dp);

            return dp[i][buy]=Math.max(s,ns);
        }


        //maximize the result 
    }
}