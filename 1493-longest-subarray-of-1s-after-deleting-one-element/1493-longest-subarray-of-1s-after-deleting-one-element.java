class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int k=1;
        int n=nums.length;
        int sum=0;
        int ans=0;
        while(i<n){
            if(nums[i]==1){
                sum++;
            }
            else if(k!=0){
                sum++;
                k--;
            }
            else{
                ans = Math.max(ans,sum);
                while(j<i && nums[j]!=0){
                    j++;sum--;
                }
                j++;
            }
            i++;
        }

        return Math.max(sum,ans)-1;
    }
}