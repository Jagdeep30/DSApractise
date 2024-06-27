class Solution {
    public int findCenter(int[][] edges) {
        // Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        // int n = 0;
        // for(int i=0;i<edges.length;i++){
        //     if(edges[i][0]>n)n=edges[i][0];
        //     if(edges[i][1]>n)n=edges[i][1];
        //     if(adj.containsKey(edges[i][0])){
        //         ArrayList<Integer> temp = adj.get(edges[i][0]);
        //         temp.add(edges[i][1]);
        //         adj.put(edges[i][0],temp);
        //     }
        //     else{
        //         ArrayList<Integer> temp = new ArrayList<>();
        //         temp.add(edges[i][1]);
        //         adj.put(edges[i][0],temp);
        //     }
        //     if(adj.containsKey(edges[i][1])){
        //         ArrayList<Integer> temp = adj.get(edges[i][1]);
        //         temp.add(edges[i][0]);
        //         adj.put(edges[i][1],temp);
        //     }
        //     else{
        //         ArrayList<Integer> temp = new ArrayList<>();
        //         temp.add(edges[i][0]);
        //         adj.put(edges[i][1],temp);
        //     }
        // }
        // for(int i: adj.keySet()){
        //     if(adj.get(i).size()==n-1)return i;
        // }
        // return 0;


        if(edges[0][0]==edges[1][0])return edges[0][0];
        if(edges[0][1]==edges[1][1])return edges[0][1];
        if(edges[0][0]==edges[1][1])return edges[0][0];
        if(edges[0][1]==edges[1][0])return edges[0][1];
        return 0;
    }
}