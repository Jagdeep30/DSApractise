class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }

        for(int i=n-1;i>=0;i--){
            if(prefix[i]>nums[i]){
                return prefix[i]+nums[i];
            }
        }

        return -1;
    }
}