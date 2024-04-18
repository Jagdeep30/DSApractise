class Solution {
    public int islandPerimeter(int[][] grid) {
        return solve(grid);
    }

    static int solve(int[][] grid){

        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int p = 0;
                    if(i-1<0 || (i-1>=0 && grid[i-1][j]==0))p+=1;
                    if(j+1==m || (j+1<m && grid[i][j+1]==0))p+=1;
                    if(i+1==n || (i+1<n && grid[i+1][j]==0))p+=1;
                    if(j-1<0 || (j-1>=0 && grid[i][j-1]==0))p+=1;

                    ans+=p;
                }
            }
        }
        return ans;
    }
}