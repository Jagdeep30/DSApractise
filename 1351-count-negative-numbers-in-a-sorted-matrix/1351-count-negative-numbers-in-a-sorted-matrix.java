class Solution {
    public int countNegatives(int[][] grid) {
        int c = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            c+=cNeg(grid[i],m);
        }
        return c;
    }
    static int cNeg(int[] arr, int n){
        int s = 0;
        int e = n-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>=0)s=mid+1;
            else e = mid;
        }
        if(arr[e]>=0)return 0;
        return n-e;
    }
}