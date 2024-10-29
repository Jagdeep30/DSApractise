class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length * matrix[0].length;
        int mid = 0;
        int r,c;
        int n = matrix[0].length;
        while(s<=e){
            mid = s + (e-s)/2;
            r = mid/n;
            c = mid%n;
            if(matrix[r][c] == target)return true;
            else if(matrix[r][c]>target){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return false;
    }
}