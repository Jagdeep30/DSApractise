class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int p=1;
        int ans=0;
        while(j<nums.length){
            p*=nums[j];
            while(i<=j && p>=k){
                p/=nums[i];
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
}