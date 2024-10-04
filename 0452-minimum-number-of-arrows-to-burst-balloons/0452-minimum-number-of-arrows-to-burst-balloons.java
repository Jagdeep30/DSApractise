class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        List<Pair<Integer,Integer>> ls = new ArrayList<>();
        int s = points[0][0];
        int e = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=e){
                s = Math.max(s,points[i][0]);
                e = Math.min(e,points[i][1]);
            }
            else{
                Pair<Integer,Integer> p = new Pair<>(s,e);
                ls.add(p);
                s = points[i][0];
                e = points[i][1];
            }
        }
        ls.add(new Pair<Integer,Integer>(s,e));
        return ls.size();
    }
}