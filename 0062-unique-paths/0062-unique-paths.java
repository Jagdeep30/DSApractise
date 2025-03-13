class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return solve(0,0,m,n,dp);
    }

    static int solve(int i, int j, int n, int m, int[][] dp){
        //base case
        if(i==n || j==m)return 0;
        if(i==n-1 && j==m-1)return 1;

        if(dp[i][j]!=0)return dp[i][j];
        int ans = 0;
        //explore all the paths
        //right
        if(j+1<m)ans+=solve(i,j+1,n,m,dp);
        //down
        if(i+1<n)ans+=solve(i+1,j,n,m,dp);
        //plus all the values
        return dp[i][j] = ans;
    }
}