class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:happiness){
            pq.add(i);
        }
        
        int c = 0;
        long sum = 0;
        while(k--!=0){
            int num = pq.poll()-c;
            sum+=Math.max(num,0);
            c++;
        }
        
        return sum;
    }
}