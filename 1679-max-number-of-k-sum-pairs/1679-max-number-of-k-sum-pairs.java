class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int j=n-1;
        int ans = 0;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum==k){
                ans++;
                i++;
                j--;
            }
            else if(sum<k)i++;
            else j--;
        }
        return ans;
    }
}