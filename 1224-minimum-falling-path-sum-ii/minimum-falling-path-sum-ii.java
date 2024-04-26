class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        // int m = grid[0].length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            ans = Math.min(ans,solve(0,i,grid,n,dp));
        }

        return ans;
    }

    static int solve(int i, int j, int[][] grid, int n, int[][] dp){
        //base case
        if(i==n-1)return grid[i][j];
        if(j<0 || j==n)return Integer.MAX_VALUE;

        // int l = Integer.MAX_VALUE;
        // int r = Integer.MAX_VALUE;
        // if(i+1<n && j-1>=0) l = solve(i+1,j-1,grid,n);
        // if(i+1<n && j+1<n)  r = solve(i+1,j+1,grid,n);

        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];



        int min = Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            if(k==j)continue;
            min = Math.min(min,solve(i+1,k,grid,n,dp));
        }

        // int min = Math.min(l,r);
        // System.out.println("min is "+min);
        return dp[i][j] = min==Integer.MAX_VALUE?grid[i][j]:min+grid[i][j];

        // return Math.min(l,r)+grid[i][j];
    }
}




// [-73, 61, 43, -48, -36]
// [ 3,  30, 27,  57,  10]
// [ 96,-76, 84,  59, -15]
// [ 5, -49, 76,  31, -7 ]
// [ 97, 91, 61, -46,  67]