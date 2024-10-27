class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> adj = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> ls = equations.get(i);
            double val = values[i];
            List<Pair<String,Double>> temp = adj.getOrDefault(ls.get(0),new ArrayList<Pair<String,Double>>());
            temp.add(new Pair<String,Double>(ls.get(1),val));
            adj.put(ls.get(0),temp);
            temp = adj.getOrDefault(ls.get(1),new ArrayList<Pair<String,Double>>());
            temp.add(new Pair<String,Double>(ls.get(0),1/val));

            adj.put(ls.get(1),temp);
        }
        // System.out.println(adj);
        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            // if(equations.contains(queries.get(i))){
            //     ans[i] = values[equations.indexOf(queries.get(i))];
            //     continue;
            // }
            // // Collections.reverse(queries.get(i));
            // if(equations.contains(queries.get(i))){
            //     ans[i] = 1/values[equations.indexOf(queries.get(i))];
            //     continue;
            // }
            // Collections.reverse(queries.get(i));
            ans[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),adj,new HashMap<String,Boolean>());
        }
        return ans;
    }

    static double dfs(String s, String e, Map<String,List<Pair<String,Double>>> adj, Map<String,Boolean> visited){
        List<Pair<String,Double>> ss = adj.getOrDefault(s,null);
        if(ss==null || adj.getOrDefault(e,null)==null)return -1.0;
        if(s.equals(e)){
            return 1.0;
        }
        double ans = 1.0;
        boolean val = false;
        double t = 1.0;
        visited.put(s,true);
        for(int i=0;i<ss.size();i++){
            double tans = !visited.getOrDefault(ss.get(i).getKey(),false)?dfs(ss.get(i).getKey(),e,adj,visited):-1.0;
            if(tans != -1.0){
                val = true;
                ans*=tans;
                t = ss.get(i).getValue();
                break;
            }
        }
        if(!val)return -1.0;
        return ans*t;
    }
}