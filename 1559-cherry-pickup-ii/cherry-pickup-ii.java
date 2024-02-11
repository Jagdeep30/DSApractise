class Solution {
    public int cherryPickup(int[][] grid) {
        // int n = grid.length;
        // int m = grid[0].length;
        // int[][][] dp = new int[n][m][m];
        // return solve(0,0,m-1,grid,n,m,dp);




        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];


        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2)dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1]+grid[n-1][j2];
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1=m-1;j1>=0;j1--){
                for(int j2=m-1;j2>=0;j2--){
                    int max = 0;
                    // ll
                    if(j1-1>=0 && j2-1>=0){
                        max = Math.max(max,dp[i+1][j1-1][j2-1]);
                    }
                    // lc
                    if(j1-1>=0){
                        max = Math.max(max,dp[i+1][j1-1][j2]);
                    }
                    // lr
                    if(j1-1>=0 && j2+1<m){
                        max = Math.max(max,dp[i+1][j1-1][j2+1]);
                    }
                    // cl
                    if(j2-1>=0){
                        max = Math.max(max,dp[i+1][j1][j2-1]);
                    }
                    // cc
                    
                        max = Math.max(max,dp[i+1][j1][j2]);
                    
                    // cr
                    if(j2+1<m){
                        max = Math.max(max,dp[i+1][j1][j2+1]);
                    }
                    // rl
                    if(j1+1<m && j2-1>=0){
                        max = Math.max(max,dp[i+1][j1+1][j2-1]);
                    }
                    // rc
                    if(j1+1<m){
                        max = Math.max(max,dp[i+1][j1+1][j2]);
                    }
                    // rr
                    if(j1+1<m && j2+1<m){
                        max = Math.max(max,dp[i+1][j1+1][j2+1]);
                    }

                    if(j1==j2){
                        max+=grid[i][j1];
                    }
                    else{
                        max+=grid[i][j1]+grid[i][j2];
                    }

                    dp[i][j1][j2]=max;
                }
            }
        }

        return dp[0][0][m-1];
    }

    // static int solve(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp){
    //     if(i>=n)return 0;
    //     if(j1<0 || j1>=m || j2<0 || j2>=m)return 0;
    //     if(i==n-1){
    //         // System.out.println("i"+i+" "+"j1->"+j1+" "+"j2->"+j2);
    //         if(j1>=0 && j1<m && j2>=0 && j2<m){
    //             if(j1==j2)return grid[i][j1];
    //             else return grid[i][j1]+grid[i][j2];
    //         }
    //         else{
    //             return 0;
    //         }
    //     }

    //     if(dp[i][j1][j2]!=0)return dp[i][j1][j2];
    //     int max = 0;
    //     // ll
    //     if(j1-1>=0 && j2-1>=0){
    //         max = Math.max(max,solve(i+1,j1-1,j2-1,grid,n,m,dp));
    //     }
    //     // lc
    //     if(j1-1>=0){
    //         max = Math.max(max,solve(i+1,j1-1,j2,grid,n,m,dp));
    //     }
    //     // lr
    //     if(j1-1>=0 && j2+1<m){
    //         max = Math.max(max,solve(i+1,j1-1,j2+1,grid,n,m,dp));
    //     }
    //     // cl
    //     if(j2-1>=0){
    //         max = Math.max(max,solve(i+1,j1,j2-1,grid,n,m,dp));
    //     }
    //     // cc
        
    //         max = Math.max(max,solve(i+1,j1,j2,grid,n,m,dp));
        
    //     // cr
    //     if(j2+1<m){
    //         max = Math.max(max,solve(i+1,j1,j2+1,grid,n,m,dp));
    //     }
    //     // rl
    //     if(j1+1<n && j2-1>=0){
    //         max = Math.max(max,solve(i+1,j1+1,j2-1,grid,n,m,dp));
    //     }
    //     // rc
    //     if(j1+1<n){
    //         max = Math.max(max,solve(i+1,j1+1,j2,grid,n,m,dp));
    //     }
    //     // rr
    //     if(j1+1<n && j2+1<m){
    //         max = Math.max(max,solve(i+1,j1+1,j2+1,grid,n,m,dp));
    //     }

    //     if(j1==j2){
    //         max+=grid[i][j1];
    //     }
    //     else{
    //         max+=grid[i][j1]+grid[i][j2];
    //     }

    //     return dp[i][j1][j2]=max;
    // }
}