class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int c=k;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        while(j<n){
            if(nums[j]==0){
                if(c!=0)c--;
                else{
                    max = Math.max(max,j-i);
                    while(i<j && nums[i]==1)i++;
                    i++;
                }
            }
            j++;
        }
        return Math.max(max,j-i);
    }
}