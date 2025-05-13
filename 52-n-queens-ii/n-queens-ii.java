class Solution {
    static int ans;
    public int totalNQueens(int n) {
        // List<List<String>> ans = new ArrayList<>();
        ans = 0;
        Map<Integer,Boolean> row = new HashMap<>();
        Map<Integer,Boolean> udiag = new HashMap<>();
        Map<Integer,Boolean> ldiag = new HashMap<>();
        // char[][] board = new char[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j] = '.';
        //     }
        // }
        solve(row,udiag,ldiag,0,n);
        return ans;
    }



    static void solve(Map<Integer,Boolean> row,Map<Integer,Boolean> udiag,Map<Integer,Boolean> ldiag, int col, int n){

        //base case
        if(col==n){
            ans++;
            return;
        }

        //processing

        for(int i=0;i<n;i++){
            if(isSafe(i,col,row,udiag,ldiag,n)){
                // board[i][col] = 'Q';
                row.put(i,true);
                ldiag.put(i+col,true);
                udiag.put(n-1+i-col,true);
                solve(row,udiag,ldiag,col+1,n);
                // board[i][col] = '.';
                row.remove(i);
                udiag.remove(n-1+i-col);
                ldiag.remove(i+col);
            }
        }


    }

    static boolean isSafe(int r, int c, Map<Integer,Boolean> row,Map<Integer,Boolean> udiag,Map<Integer,Boolean> ldiag,int n){
        if(row.keySet().contains(r))return false;
        if(ldiag.keySet().contains(r+c))return false;
        if(udiag.keySet().contains(n-1+r-c))return false;
        return true;
    }
}