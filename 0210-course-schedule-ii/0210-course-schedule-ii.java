class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        int[] courses = new int[numCourses];
        Map<Integer,Integer> res = new HashMap<>();
        Map<Integer,List<Integer>> mp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<p.length;i++){
            List<Integer> ls = mp.getOrDefault(p[i][0],new ArrayList<Integer>());
            ls.add(p[i][1]);
            mp.put(p[i][0],ls);
        }
        boolean ans = true;
        for(int i=0;i<numCourses;i++){
            int t = res.getOrDefault(i,2);
            if(t==2){
                Boolean a = dfs(i,new HashMap<Integer,Boolean>(),res,mp,arr);
                if(!a)return new int[0];
                res.put(i,a?1:0);
                ans = ans && a;
            }
            else{
                ans = ans && (t==0?false:true);
            }
            if(!arr.contains(i))arr.add(i);
        }
        // System.out.println(res);
        if(ans){
            for(int i=0;i<numCourses;i++){
                courses[i] = arr.get(i);
            }
            return courses;
        }
        return new int[0];
    }
    static boolean dfs(int i, Map<Integer,Boolean> visited, Map<Integer,Integer> res, Map<Integer,List<Integer>> mp, List<Integer> arr){
        // if(visited.getOrDefault(i,false)){
            int t = res.getOrDefault(i,2);
            if(t!=2){
                return t==1?true:false;
            }
        // }
        // if(res.getOrDefault(i,2)!=2){
        //     int t = res.getOrDefault(i,2);
        //     if(t!=2)return t==1?true:false;
        // }
        if(mp.getOrDefault(i,null)==null)return true;

        boolean ans = true;
        visited.put(i,true);
        List<Integer> ls = mp.get(i);
        for(int j=0;j<ls.size();j++){
            if(!visited.getOrDefault(ls.get(j),false)){
                if(res.getOrDefault(ls.get(j),2)==2){
                    boolean temp = dfs(ls.get(j),visited,res,mp,arr);
                    if(!temp)return false;
                    if(!arr.contains(ls.get(j)))arr.add(ls.get(j));
                    res.put(ls.get(j),temp?1:0);
                }
            }   
            ans = ans && res.getOrDefault(ls.get(j),2)==1?true:false;
        }

        res.put(i,ans?1:0);
        if(!arr.contains(i))arr.add(i);
        return ans;
    }
}