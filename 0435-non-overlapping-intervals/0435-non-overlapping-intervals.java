class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0]<b[0]?1:0;
        });
        int l = intervals[0][0];
        int r = intervals[0][1];

        int ans = 0;

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=r){
                r = intervals[i][1];
                l = intervals[i][0];
            }
            else{
                if(intervals[i][1]<r){
                    r = intervals[i][1];
                    l = intervals[i][0];
                }
                ans++;
            }
        }
        return ans;
    }
}