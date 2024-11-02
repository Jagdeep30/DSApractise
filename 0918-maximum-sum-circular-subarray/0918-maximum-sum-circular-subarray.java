class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int maxE = Integer.MIN_VALUE;
        int maxT = Integer.MIN_VALUE;
        // List<Integer> ls = new ArrayList<>();
        // for(int i=0;i<nums.length;i++)ls.add(nums[i]);
        // for(int i=0;i<nums.length-1;i++)ls.add(nums[i]);
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            maxE = Math.max(nums[i],maxE);
            if(sum<0)sum = 0;
            sum += (-nums[i]);
            max = Math.max(max,sum);
        }
        sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum<0)sum = 0;
            sum += (nums[i]);
            maxT = Math.max(maxT,sum);
        }
        if(maxE<0)return maxE;
        return Math.max(total - (-max),maxT);
    }
}