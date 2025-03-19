class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            // return a[0]<b[0]?1:0;
            // return a[0]!=b[0]?a[0]<b[0]?1:0:a[1]<b[1]?1:0;
            if(a[0]==b[0])return a[1]<=b[1]?-1:1;
            else return a[0]<=b[0]?-1:1;
        });
        // for(int i=0;i<intervals.length;i++)System.out.println(Arrays.toString(intervals[i]));
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