class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add((int)Math.pow(nums[i],2));
        }

        for(int i=0;i<n;i++){
            nums[i] = pq.poll();
        }

        return nums;
    }
}