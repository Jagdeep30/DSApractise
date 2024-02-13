class Solution {
    public int maxSubArray(int[] nums) {
        int max = -10001;
        int n = nums.length;

        // int s = 0;
        int e = 0;
        int sum = 0;
        while(e<n){
            sum+=nums[e];
            if(sum>max)max=sum;
            if(sum<0){
                // s=e=e+1;
                sum=0;
            }
            e++;
        }

        return max;
    }
}