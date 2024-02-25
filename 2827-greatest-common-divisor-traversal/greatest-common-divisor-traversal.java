class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        Map<Integer,List<Integer>> prime = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> pF = findPrimeFactors(nums[i]);
            for(int ele : pF){
                List<Integer> temp = prime.getOrDefault(ele,new ArrayList<>());
                temp.add(i);
                prime.put(ele,temp);
            }
        }

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> e: prime.entrySet()){
            List<Integer> eles = e.getValue();
            for(int i=0;i<eles.size()-1;i++){
                List<Integer> temp = adj.getOrDefault(eles.get(i),new ArrayList<Integer>());
                temp.add(eles.get(i+1));
                adj.put(eles.get(i),temp);

                temp = adj.getOrDefault(eles.get(i+1),new ArrayList<Integer>());
                temp.add(eles.get(i));
                adj.put(eles.get(i+1),temp);
            }
        }
        boolean[] visited = new boolean[nums.length];
        dfs(adj,visited,0);

        for(boolean ele : visited){
            if(!ele)return false;
        }

        return true;
    }

    static void dfs(Map<Integer,List<Integer>> adj, boolean[] visited, int node){

        visited[node] = true;
        List<Integer> temp = adj.get(node);
        if(temp==null)return;
        for(int ele : temp){
            if(!visited[ele]){
                dfs(adj,visited,ele);
            }
        }
    }

    static List<Integer> findPrimeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        if(n%2==0){
            ans.add(2);
            while(n%2==0)n/=2;
        }
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                ans.add(i);
                while(n%i==0)n/=i;
            }
            // if(n==0)break;
        }

        if(n>2){
            ans.add(n);
        }

        return ans;
    }
}