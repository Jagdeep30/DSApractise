class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        boolean s = dfs(source, visited,adj,destination);
        if(s)return s;
        boolean d = dfs(destination, visited,adj,source);
        if(d)return d;

        return false;
    }

    static boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int dest){
        if(node==dest)return true;
        visited[node] = true;

        for(int i=0;i<adj.get(node).size();i++){
            if(!visited[adj.get(node).get(i)]){
                boolean res = dfs(adj.get(node).get(i),visited,adj,dest);
                if(res)return true;
            }
        }
        return false;
    }
}