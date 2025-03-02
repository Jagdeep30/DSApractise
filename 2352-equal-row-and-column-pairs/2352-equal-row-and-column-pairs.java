class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> mp = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                ls.add(grid[i][j]);
            }
            mp.put(ls,mp.getOrDefault(ls,0)+1);
        }

        int ans = 0;
        for(int i=0;i<grid.length;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<grid.length;j++){
                ls.add(grid[j][i]);
            }
            // mp.put(ls,mp.getOrDefault(ls,0)+1);
            ans+=mp.getOrDefault(ls,0);
        }
        System.out.println(mp);
        // int ans = 0;
        // for(Map.Entry<List<Integer>, Integer> e: mp.entrySet()){
        //     ans+=e.getValue()/2;
        // }
        return ans;
    }
}