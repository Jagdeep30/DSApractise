class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        Map<Integer,Boolean> row = new HashMap<>();
        Map<Integer,Boolean> udiag = new HashMap<>();
        Map<Integer,Boolean> ldiag = new HashMap<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        solve(ans,row,udiag,ldiag,board,0,n);
        return ans;
    }
    static void solve(List<List<String>> ans,Map<Integer,Boolean> row,Map<Integer,Boolean> udiag,Map<Integer,Boolean> ldiag,char[][] board, int col, int n){

        //base case
        if(col==n){
            ArrayList<String> temp = new ArrayList<>();
            String s = "";
            for(int i=0;i<n;i++){
                s="";
                for(int j=0;j<n;j++){
                    s+=board[i][j];
                }
                temp.add(s);
            }
            ans.add(temp);
        }

        //processing

        for(int i=0;i<n;i++){
            if(isSafe(i,col,row,udiag,ldiag,n)){
                board[i][col] = 'Q';
                row.put(i,true);
                ldiag.put(i+col,true);
                udiag.put(n-1+i-col,true);
                solve(ans,row,udiag,ldiag,board,col+1,n);
                board[i][col] = '.';
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