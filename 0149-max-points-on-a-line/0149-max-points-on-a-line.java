class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<=2)return points.length;
        int ans = 0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int total = 2;
                for(int k=0;k<points.length;k++){
                    if(k!=i && k!=j){
                        // y2-y1 * x3-x1     =    y3-y1 * x2-x1
                        if((points[j][1]-points[i][1]) * (points[k][0]-points[i][0]) == (points[k][1]-points[i][1]) * (points[j][0]-points[i][0]))total++;
                    }
                }
                ans = Math.max(ans,total);
            }
        }
        return ans;
    }
}