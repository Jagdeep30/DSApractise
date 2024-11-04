class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return solve(0,0,grid,dp);
    }
    static int solve(int i, int j, int[][] grid, int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1)return grid[i][j];
        if(i==grid.length || j==grid[0].length)return 1000000;

        if(dp[i][j]!=-1)return dp[i][j];

        //explore all paths
        return dp[i][j] = Math.min(solve(i,j+1,grid,dp),solve(i+1,j,grid,dp))+grid[i][j];
    }
}