class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<p.length;i++){
            // if(p[i][0]==p[i][1])continue;
            List<Integer> ls  = mp.getOrDefault(p[i][0],new ArrayList<Integer>());
            // mp.put(p[i][0],p[i][1]);
            ls.add(p[i][1]);
            mp.put(p[i][0],ls);
        }
        boolean ans = true;
        Map<Integer,Boolean> res = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            if(res.getOrDefault(i,false)){
                ans = ans && res.get(i);
                // System.out.println("ans for "+i+" are "+res.get(i));
                continue;
            }
            boolean r = dfs(i,numCourses,mp,new HashMap<>(),res);
            ans = ans && r;
            // System.out.println("ans for "+i+" is "+r);
            res.put(i,r);
        }
        return ans;
    }

    static boolean dfs(int i, int numCourses, Map<Integer,List<Integer>> mp, Map<Integer,Boolean> visited, Map<Integer,Boolean> r){
        // System.out.println("reached");
        if(mp.getOrDefault(i,null)==null)return true;
        if(i>=numCourses)return true;
        if(r.getOrDefault(i,false))return true;
// System.out.println(i);
        visited.put(i,true);
        List<Integer> ls = mp.get(i);
        if(ls==null)return true;
        boolean ans = true;
        for(int j=0;j<ls.size();j++){
            if(!visited.getOrDefault(ls.get(j),false)){
                if(r.getOrDefault(ls.get(j),false)){
                    ans = ans && r.get(ls.get(j));
                    // System.out.println("ans for "+j+" are "+r.get(ls.get(j)));
                    continue;
                }
                boolean rr = dfs(ls.get(j),numCourses,mp,visited,r);
                ans = ans && rr;
                r.put(ls.get(j),rr);
                // System.out.println("ans for "+j+" is "+rr);
            }
            else ans = r.getOrDefault(ls.get(j),false);
        }
        // visited.put(i,false);
        // System.out.println("end for "+i+" were "+ans);
        r.put(i,ans);
        return ans;
    }
}