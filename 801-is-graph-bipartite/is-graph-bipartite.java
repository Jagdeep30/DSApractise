class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer,Integer> visited = new HashMap<>();

        for(int i=0;i<graph.length;i++){
            if(visited.getOrDefault(i,0)!=0)continue;

            if(!bfs(i, visited, graph))return false;
        }

        return true;
    }

    boolean bfs(int node, Map<Integer,Integer> v, int[][] arr){
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        v.put(node, 1);

        while(!q.isEmpty()){
            int i = q.poll();

            int c = v.get(i);
            int t = c==1?2:1;

            for(int j=0;j<arr[i].length;j++){
                int val = v.getOrDefault(arr[i][j],0);
                if(val==0){
                    v.put(arr[i][j], t);
                    q.add(arr[i][j]);
                }
                else{
                    if(val==c){
                        return false;
                    }
                }
            }   

        }
        return true;         
    }
}