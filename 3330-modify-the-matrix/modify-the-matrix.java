class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] max = new int[m];
        for(int c=0;c<m;c++){
            int maxi = -2;
            for(int r=0;r<n;r++){
                maxi = Math.max(maxi,matrix[r][c]);
            }
            max[c]=maxi;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=max[j];
                }
            }
        }
        return matrix;
    }
}