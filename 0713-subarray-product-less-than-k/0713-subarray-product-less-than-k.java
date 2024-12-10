class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)return 0;

        int ans = 0;
        int n = nums.length;
        int s = 0;
        int e = 0;
        int product = 1;

        while(e<n){
            product*=nums[e++];
            while(s<e && product>=k)product/=nums[s++];

            ans+=(e-s);
        }

        return ans;
    }
}