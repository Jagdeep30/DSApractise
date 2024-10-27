class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<p.length;i++){
            List<Integer> ls  = mp.getOrDefault(p[i][0],new ArrayList<Integer>());
            ls.add(p[i][1]);
            mp.put(p[i][0],ls);
        }
        boolean ans = true;
        Map<Integer,Boolean> res = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            if(!res.getOrDefault(i,false)){
                res.put(i,dfs(i,numCourses,mp,new HashMap<>(),res));
                // System.out.println("ans for "+i+" are "+res.get(i));
            }
            ans = ans && res.get(i);
            // System.out.println("ans for "+i+" is "+r);
        }
        return ans;
    }

    static boolean dfs(int i, int numCourses, Map<Integer,List<Integer>> mp, Map<Integer,Boolean> visited, Map<Integer,Boolean> r){
        if(mp.getOrDefault(i,null)==null)return true;
        if(r.getOrDefault(i,false))return true;
        visited.put(i,true);
        List<Integer> ls = mp.get(i);
        boolean ans = true;
        for(int j=0;j<ls.size();j++){
            int num = ls.get(j);
            if(!visited.getOrDefault(num,false)){
                if(!r.getOrDefault(num,false)){
                    r.put(num,dfs(num,numCourses,mp,visited,r));
                }
            }
            ans = ans && r.getOrDefault(num,false);
        }
        r.put(i,ans);
        return ans;
    }
}