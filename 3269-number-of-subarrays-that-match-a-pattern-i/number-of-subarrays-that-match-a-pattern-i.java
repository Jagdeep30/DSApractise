class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int len = pattern.length;
        int n = nums.length;
        int ans = 0;
        
        for(int i=0;i<n-len;i++){
            boolean res = verifyPattern(nums,i,i+len,pattern);
            if(res)ans++;
        }
        
        return ans;
    }
    
    public static boolean verifyPattern(int[] nums, int i, int j, int[] pattern){
        if(pattern.length==1){
            if(pattern[0]==1 && nums[j]>nums[i])return true;
            else if(pattern[0]==0 && nums[j]==nums[i])return true;
            else if(pattern[0]==-1 && nums[j]<nums[i])return true;
            else return false;
        }
        
        int t = 0;
        for(int k=i;k<j;k++){
            if(pattern[t]==1 && nums[k+1]<=nums[k])return false;
            else if(pattern[t]==0 && nums[k+1]!=nums[k])return false;
            else if(pattern[t]==-1 && nums[k]<=nums[k+1])return false;
            t++;
        }
        
        return true;
    }
}