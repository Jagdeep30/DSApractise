class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> temp = new ArrayList<>();

        int n = intervals.length;
        for(int i=0;i<n;i++){
            if(intervals[i][0]<=newInterval[0]){
                if(newInterval[0]<=intervals[i][1]){
                    newInterval[0] = intervals[i][0];
                    newInterval[1] = Math.max(newInterval[1],intervals[i][1]);


                    // List<Integer> t = new ArrayList<>();
                    // t.add(newInterval[0]);
                    // t.add(Math.max(newInterval[1],intervals[i][1]));
                    // temp.add(t);
                }
                else{
                    List<Integer> t = new ArrayList<>();
                    t.add(intervals[i][0]);
                    t.add(intervals[i][1]);
                    temp.add(t);
                }
            }
            else{
                
                if(intervals[i][0]<=newInterval[1]){
                    // newInterval[0] = intervals[i][0];
                    newInterval[1] = Math.max(newInterval[1],intervals[i][1]);


                    // List<Integer> t = new ArrayList<>();
                    // t.add(newInterval[0]);
                    // t.add(Math.max(newInterval[1],intervals[i][1]));
                    // temp.add(t);
                }
                else{
                    List<Integer> t = new ArrayList<>();
                    t.add(newInterval[0]);
                    t.add(newInterval[1]);
                    temp.add(t);
                    newInterval[0] = intervals[i][0];
                    newInterval[1] = intervals[i][1];
                }
            }
        }

        List<Integer> tt = new ArrayList<>();
        tt.add(newInterval[0]);
        tt.add(newInterval[1]);
        temp.add(tt);


        int[][] ans = new int[temp.size()][2];
        int i=0;
        for(List<Integer> t:temp){
            ans[i][0] = t.get(0);
            ans[i][1] = t.get(1);
            i++;
        };



        return ans;
    }
}