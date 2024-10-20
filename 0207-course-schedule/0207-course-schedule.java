class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++){
            ArrayList<Integer> temp = adj.get(pre[i][1]);
            temp.add(pre[i][0]);
            adj.put(pre[i][1],temp);
        }
        
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Boolean> visitedDfs = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            visited.add(false);
            visitedDfs.add(false);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited.get(i))
            if(!dfs(adj,i,visitedDfs,visited))return false;
        }
        return true;
    }

    static boolean dfs(Map<Integer,ArrayList<Integer>> adj,int node, ArrayList<Boolean> visitedDfs,ArrayList<Boolean> visited){

        visited.set(node,true);
        visitedDfs.set(node,true);

        for(int i=0;i<adj.get(node).size();i++){
            if(visited.get(adj.get(node).get(i))==true && visitedDfs.get(adj.get(node).get(i))==true){
                return false;
            }
            if(!visited.get(adj.get(node).get(i))){
                boolean res = dfs(adj,adj.get(node).get(i),visitedDfs,visited);
                if(!res)return false;
            }
        }
        visitedDfs.set(node,false);
        return true;
    }
}