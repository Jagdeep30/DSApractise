class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                dfs(board,1,i);
            }
            if(board[n-1][i]=='O'){
                dfs(board,n-2,i);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board,i,1);
            }
            if(board[i][m-1]=='O'){
                dfs(board,i,m-2);
            }
        }

        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O')board[i][j]='X';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='1')board[i][j]='O';
            }
        }
        return;
    }

    static void dfs(char[][] b, int i, int j){
        if(i==0 || j==0 || i==b.length-1 || j==b[0].length-1 || b[i][j]=='X' || b[i][j]=='1')return;

        b[i][j] = '1';
        dfs(b,i-1,j);
        dfs(b,i,j+1);
        dfs(b,i+1,j);
        dfs(b,i,j-1);
        return;
        
    }
}