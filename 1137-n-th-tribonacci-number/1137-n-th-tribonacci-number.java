class Solution {
    int[] dp = new int[38];
    public int tribonacci(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        
        if(dp[n]!=0)return dp[n];
        int n1 = dp[n-1]!=0?dp[n-1]:tribonacci(n-1);
        int n2 = dp[n-2]!=0?dp[n-2]:tribonacci(n-2);
        int n3 = dp[n-3]!=0?dp[n-3]:tribonacci(n-3);

        return dp[n] = n1 + n2 + n3;
    }
}