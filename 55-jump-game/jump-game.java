class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(i>max)return false;
            max = Math.max(max,i+nums[i]);
        }
        
        return nums.length-1 <= max;
    }
}