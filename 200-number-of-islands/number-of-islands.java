class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        Map<Integer,Boolean> visited = new HashMap<>();
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    int index = c*i+j;
                    if(!visited.getOrDefault(index,false)){
                        // System.out.println(index);
                        ans++;
                        dfs(grid,i,j,visited);
                    }   
                }
            }
        }
        return ans;
    }

    static void dfs(char[][] grid, int row, int col, Map<Integer,Boolean> visited){
        int tr = grid.length;
        int tc = grid[0].length;
        int index = tc * row + col;
        visited.put(index,true);
        // System.out.println(index+" => true");

        //traversing over adjacent nodes
        //check three conditions for each adjacent node
        // 1) it is within the grid
        // 2) it is not zero
        // 3) it is not visited
        int nr = row;
        int nc = col;
        //up node
        nc=col;
        nr=row-1;
        if(nr>=0 && grid[nr][nc]!='0' && !visited.getOrDefault(tc*nr+nc,false)){
            dfs(grid,nr,nc,visited);
        }
        //down node
        nc=col;
        nr=row+1;
        if(nr<tr && grid[nr][nc]!='0' && !visited.getOrDefault(tc*nr+nc,false)){
            dfs(grid,nr,nc,visited);
        }
        //left node
        nr=row;
        nc=col-1;
        if(nc>=0 && grid[nr][nc]!='0' && !visited.getOrDefault(tc*nr+nc,false)){
            dfs(grid,nr,nc,visited);
        }
        //right node
        nr=row;
        nc=col+1;
        if(nc<tc && grid[nr][nc]!='0' && !visited.getOrDefault(tc*nr+nc,false)){
            dfs(grid,nr,nc,visited);
        }

        return;
    }
}