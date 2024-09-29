class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] temp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j] = board[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // int h1=0,h2=0,h3=0,h4=0,h5=0,h6=0,h7=0,h8=0;
                int sum = 0;
                if(i-1>=0 && j-1>=0)sum+=temp[i-1][j-1];
                if(i-1>=0)sum+=temp[i-1][j];
                if(i-1>=0 && j+1<m)sum+=temp[i-1][j+1];
                if(j+1<m)sum+=temp[i][j+1];
                if(i+1<n && j+1<m)sum+=temp[i+1][j+1];
                if(i+1<n)sum+=temp[i+1][j];
                if(i+1<n && j-1>=0)sum+=temp[i+1][j-1];
                if(j-1>=0)sum+=temp[i][j-1];

                if(board[i][j]==1){
                    if(sum<2 || sum>3)board[i][j] = 0;
                }
                else{
                    if(sum==3)board[i][j] = 1;
                }
            }
        }
    }
}