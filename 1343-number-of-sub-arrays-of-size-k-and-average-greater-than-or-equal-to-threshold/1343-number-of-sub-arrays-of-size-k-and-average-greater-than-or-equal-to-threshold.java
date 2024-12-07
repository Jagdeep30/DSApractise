class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum = 0;
        for(int i=0;i<k;i++)sum+=nums[i];
        int c = 0;
        if(sum/k>=threshold)c++;
        // int i=0;
        int j=0;
        // max = Math.max(max,(double)sum/k);
        // int j=0;
        for(int i=k;i<nums.length;i++){
            sum-=nums[j++];
            sum+=nums[i];
            // max = Math.max(max,(double)sum/k);
            if(sum/k>=threshold)c++;
        }
        return c;
    }
}