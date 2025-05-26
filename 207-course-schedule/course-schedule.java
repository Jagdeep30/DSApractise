class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<p.length;i++){
            List<Integer> ls = mp.getOrDefault(p[i][0], new ArrayList<Integer>());
            ls.add(p[i][1]);
            mp.put(p[i][0], ls);
        }

        Map<Integer, Integer> visited = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            if(visited.getOrDefault(i, 0) == 1)continue;

            if(!traverse(mp,visited,i))return false;
        }

        return true;
    }

    boolean traverse(Map<Integer,List<Integer>> mp, Map<Integer, Integer> visited, int node){
        int vst = visited.getOrDefault(node,0);
        if(vst==1)return true;
        if(vst==2)return false;

        visited.put(node,2);

        List<Integer> ls = mp.getOrDefault(node, new ArrayList<>());

        for(int i=0;i<ls.size();i++){
            if(!traverse(mp,visited,ls.get(i)))return false;
        }

        visited.put(node,1);
        return true;
    }
}