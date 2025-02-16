class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>=target){
                min = Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min!=Integer.MAX_VALUE?min:0;
    }
}