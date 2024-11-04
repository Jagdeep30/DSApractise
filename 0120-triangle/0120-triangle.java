class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return solve(0,0,triangle,dp);
    }

    static int solve(int i, int j, List<List<Integer>> triangle, int[][] dp){
        //base case
        if(i==triangle.size() || j==triangle.get(i).size())return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        //explore all paths
        return dp[i][j] = Math.min(solve(i+1,j,triangle,dp),solve(i+1,j+1,triangle,dp))+triangle.get(i).get(j);
    }
}