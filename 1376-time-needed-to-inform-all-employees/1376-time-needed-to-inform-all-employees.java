class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            List<Integer> ls = mp.getOrDefault(manager[i],new ArrayList<Integer>());
            ls.add(i);
            mp.put(manager[i],ls);
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer,Integer>(headID,0));
        while(!q.isEmpty()){
            Pair<Integer,Integer> temp = q.poll();
            max = Math.max(max,temp.getValue());
            // res+=informTime[temp];
            List<Integer> ls = mp.getOrDefault(temp.getKey(),new ArrayList<Integer>());
            for(int i=0;i<ls.size();i++)q.add(new Pair<Integer,Integer>(ls.get(i),informTime[temp.getKey()]+temp.getValue()));
        }

        return max;
    }
}