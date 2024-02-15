class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // long[] prefix = new long[n];
        long max = 0;
        for(int i=0;i<n-1;i++){
            // prefix[i] = prefix[i-1]+nums[i-1];
            max+=nums[i];
        }

        for(int i=n-1;i>=2;i--){
            // if(prefix[i]>nums[i]){
            //     return prefix[i]+nums[i];
            // }
            if(max>nums[i])return max+nums[i];
            
            max-=nums[i-1];
        }

        return -1;
    }
}