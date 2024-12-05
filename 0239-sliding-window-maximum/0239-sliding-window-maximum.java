class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // if(q.isEmpty())q.add(i);
            if(!q.isEmpty() && q.peekFirst()<=i-k)q.poll();
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()])q.pollLast();

            q.add(i);

            if(i>=k-1){
                ans[i-k+1] = nums[q.peek()];
            }
        }
        return ans;
    }
}