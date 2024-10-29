class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int c = matrix[0].length;
        int e = matrix.length * (c) - 1;

        while(s<=e){
            int mid = s + (e-s)/2;
            int r = mid/c;
            int col = mid%c;
            System.out.println(mid);
            int ele = matrix[r][col];
            if(ele==target)return true;
            else if(ele<target)s = mid+1;
            else e = mid-1;
        }
        return false;
    }
}