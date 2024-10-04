class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int s = intervals[0][0];
        int e = intervals[0][1];
        List<Pair<Integer,Integer>> ls = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=e){
                s = Math.min(s,intervals[i][0]);
                e = Math.max(e,intervals[i][1]);
            }
            else{
                Pair<Integer,Integer> p = new Pair<>(s,e);
                s = intervals[i][0];
                e = intervals[i][1];
                ls.add(p);
            }
        }
        Pair<Integer,Integer> pp = new Pair<>(s,e);
        ls.add(pp);
        int[][] ans = new int[ls.size()][2];
        int i=0;
        for(Pair<Integer,Integer> p: ls){
            ans[i] = new int[]{p.getKey(),p.getValue()};
            i++;
        }

        return ans;
    }
}