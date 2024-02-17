class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            int diff = heights[i+1]-heights[i];
            if(diff>0){
                if(pq.size()<ladders){
                    pq.add(diff);
                }
                else{
                    if(pq.isEmpty() || diff<=pq.peek()){
                        bricks-=diff;
                    }
                    else{
                        bricks-=pq.poll();
                        pq.add(diff);
                    }
                    if(bricks<0)return i;
                }
            }
        }
        return n-1;
    }
}