class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] t = new int[intervals.length][3];
        for(int i=0;i<intervals.length;i++){
            int[] temp = new int[3];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            temp[2] = i;
            t[i] = temp;
        }
        Arrays.sort(t,(a,b)->{
            return a[0]-b[0];
        });
        // for(int i=0;i<t.length;i++)System.out.println(Arrays.toString(t[i]));

        int[] ans = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            int ele = findElement(t,intervals[i][1]);
            if(intervals[ele][0]>=intervals[i][1])ans[i]=ele;
            else ans[i] = -1;
        }
        return ans;
    }

    static int findElement(int[][] t, int e){
        int s = 0;
        int en = t.length-1;
        while(s<en){
            int mid = s + (en-s)/2;
            if(t[mid][0]>=e)en = mid;
            else s = mid+1;
        }
        return t[en][2];
    }
}