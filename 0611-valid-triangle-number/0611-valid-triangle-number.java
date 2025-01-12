class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int k=n-1;k>1;k--){
            int i=0;
            int j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    ans += j-i;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }
}