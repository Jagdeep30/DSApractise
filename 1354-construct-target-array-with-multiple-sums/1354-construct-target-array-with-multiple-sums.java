class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for(int i=0;i<target.length;i++){
            pq.add((long)target[i]);
            sum+=target[i];
        }
        while(pq.peek()!=1){
            long temp = pq.poll();
            sum = sum - temp;
            if(sum<=0 || sum>=temp)return false;
            temp = temp % sum;
            pq.add(temp>0?temp:sum);
            sum += temp;
        }
        return true;
    }
}