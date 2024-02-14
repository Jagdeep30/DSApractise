class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer,Boolean> mp = new HashMap<>();
        int dup = 0;
        int n = grid.length;
        // int m = grid[0].length;
        // int dup = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mp.getOrDefault(grid[i][j],false)){
                    dup = grid[i][j];
                    break;
                }
                mp.put(grid[i][j],true);
            }
        }

        int xor = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=dup)xor^=grid[i][j];
            }
        }
        xor^=dup;
        for(int i=1;i<=n*n;i++){
            xor^=i;
        }
        return new int[]{dup,xor};
    }
}