class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int common = points[0][1];

        int count = 0;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=common){
                // common[0] = points[i][0];
                common = Math.min(points[i][1],common);
            }
            else{
                count++;
                common = points[i][1];
            }
        }

        return count+1;

    }
}