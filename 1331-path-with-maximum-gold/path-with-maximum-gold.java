class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans = Math.max(ans,solve(i,j,grid,grid.length,grid[0].length));
            }
        }
        return ans;
    }

    static int solve(int i, int j, int[][] grid, int m, int n){
        //base case
        if(grid[i][j]==-1 || grid[i][j]==0)return 0;

        int sum = grid[i][j];
        int l=0;
        int u=0;
        int d = 0;
        int r = 0;
        grid[i][j] = -1;

        if(i-1>=0 && j<n)u = solve(i-1,j,grid,m,n);
        if(i<m && j+1<n)r = solve(i,j+1,grid,m,n);
        if(i+1<m && j<n)d = solve(i+1,j,grid,m,n);
        if(i<m && j-1>=0)l = solve(i,j-1,grid,m,n);

        grid[i][j] = sum;
        sum += Math.max(Math.max(u,r),Math.max(d,l));

        return sum;
    }
}