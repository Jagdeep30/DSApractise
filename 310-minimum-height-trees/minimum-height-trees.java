class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> indegree = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        if(n==1){
            ans.add(0);
            return ans;
        }
        if(n==2){
            ans.add(0);
            ans.add(1);
            return ans;
        }

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //filling the indegree for each node
        for(int i=0;i<n;i++){
            indegree.add(0);
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                int ele = adj.get(i).get(j);
                indegree.set(ele,indegree.get(ele)+1);
            }
        }
        for(int ele=0;ele<indegree.size();ele++){
            if(indegree.get(ele)==1){
                q.add(ele);
                indegree.set(ele,0);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int s = q.size();
            ans.clear();

            for(int i=0;i<s;i++){
                int ele = q.poll();
                ans.add(ele);
                for(int j=0;j<adj.get(ele).size();j++){
                    indegree.set(adj.get(ele).get(j),indegree.get(adj.get(ele).get(j))-1);
                    if(indegree.get(adj.get(ele).get(j))==1)q.add(adj.get(ele).get(j));
                }
            }
        }
        return ans;
    }
}











// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         int[] mht = new int[n];
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<Integer>());
//         }
//         for(int i=0;i<edges.length;i++){
//             adj.get(edges[i][0]).add(edges[i][1]);
//             adj.get(edges[i][1]).add(edges[i][0]);
//         }
//         for(int i=0;i<n;i++){
//             int h = solve(adj,n,i);
//             mht[i] = h;
//         }
//         System.out.println(mht);
//         List<Integer> ans = new ArrayList<>();
//         return ans;
//     }

//     static int solve(ArrayList<ArrayList<Integer>> adj,int n,int node){
//         Queue<Integer> q = new ArrayDeque<>();
//         q.add(node);
//         q.add(-1);
//         int height = 0;
//         while(!q.isEmpty()){
//             int front = q.poll();
//             if(front == -1){
//                 height++;
//                 q.add(-1);
//                 continue;
//             }
//             for(int i=0;i<adj.get(front).size();i++){
//                 q.add(adj.get(front).get(i));
//             }
//         }
//         return height;
//     }
// }