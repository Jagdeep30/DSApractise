class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j || isConnected[i][j]==0){
                    continue;
                }
                List<Integer> temp = mp.getOrDefault(i, new ArrayList<Integer>());
                // List<Integer> temp2 = mp.getOrDefault(j, new ArrayList<Integer>());
                temp.add(j);
                // temp2.add(i);
                mp.put(i, temp);
                // mp.put(j, temp2);
            }
        }

            // System.out.println(mp);
        int ans = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            // System.out.println(i);
            if(visited[i])continue;
            // System.out.println("not visited -> "+ i);
            ans++;
            traverse(i, mp, visited);
        }

        return ans;
    }

    static void traverse(int i, Map<Integer,List<Integer>> mp, boolean[] visited){
        visited[i] = true;

        List<Integer> ls = mp.getOrDefault(i, new ArrayList<>());
        for(int j=0;j<ls.size();j++){
            if(visited[ls.get(j)])continue;
            traverse(ls.get(j),mp,visited);
        }
    }
}