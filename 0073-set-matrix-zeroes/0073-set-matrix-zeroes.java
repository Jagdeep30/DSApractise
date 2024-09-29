class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean zero = matrix[0][0]==0?true:false;
        boolean rzero = false;
        boolean czero = false;
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                czero = true;
                break;
            }
        }
        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                rzero = true;
                break;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++)matrix[i][j]=0;
            }
        }
        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++)matrix[i][j]=0;
            }
        }

        if(zero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(rzero){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(czero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        return ;
    }
}