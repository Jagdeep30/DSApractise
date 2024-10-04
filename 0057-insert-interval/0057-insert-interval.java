class Solution {
    public int[][] insert(int[][] intervals, int[] ins) {
        int i=0;
        int n=intervals.length;
        while(i<n && ins[0]>intervals[i][1])i++;
        if(i==n){
            int[][] ans = new int[n+1][2];
            for(int j=0;j<n;j++){
                ans[j] = intervals[j];
            }
            ans[n] = new int[]{ins[0],ins[1]};
            return ans;
        }
        else{
            List<Pair<Integer,Integer>> ls = new ArrayList<>();
            mergeIntervals(ls,ins,intervals,i);
            int[][] ans = new int[ls.size()][2];
            i=0;
            for(Pair<Integer,Integer> p: ls){
                ans[i++] = new int[]{p.getKey(),p.getValue()};
            }
            return ans;
        }
    }
    static void mergeIntervals(List<Pair<Integer,Integer>> ls, int[] ins, int[][]intervals, int i){
        for(int j=0;j<i;j++){
            Pair<Integer,Integer> p = new Pair<>(intervals[j][0],intervals[j][1]);
            ls.add(p);
        }
        int s = Math.min(ins[0],intervals[i][0]);
        int e = Math.max(ins[1],intervals[i][1]);
        if(ins[1]<intervals[i][0]){
            Pair<Integer,Integer> p = new Pair<>(ins[0],ins[1]);
            s = intervals[i][0];
            e = intervals[i][1];
            ls.add(p);
        }
        for(int j=i+1;j<intervals.length;j++){
            if(intervals[j][0]<=e){
                s = Math.min(s,intervals[j][0]);
                e = Math.max(e,intervals[j][1]);
            }
            else{
                Pair<Integer,Integer> p = new Pair<>(s,e);
                s = intervals[j][0];
                e = intervals[j][1];
                ls.add(p);
            }
        }
        Pair<Integer,Integer> p = new Pair<>(s,e);
        ls.add(p);
        return;
    }
}