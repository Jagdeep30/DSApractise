class Solution {
    public void rotate(int[][] matrix) {
        //reverse matrix and then swap i,j with j,i
        int i=0;
        int j=matrix.length-1;
        while(i<j){
            int[] t = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = t;
            i++;
            j--;
        }

        for(int r=0;r<matrix.length;r++){
            for(int c=r;c<matrix.length;c++){
                int n = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = n;
            }
        }

        // return matrix;
    }
}