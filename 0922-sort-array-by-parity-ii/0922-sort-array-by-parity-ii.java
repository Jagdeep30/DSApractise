class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j=0;//odd
        int k=0;//even
        while(j<nums.length && k<nums.length){
            while(j<nums.length && nums[j]%2==0)j++;
            while(k<nums.length && nums[k]%2!=0)k++;
            ans[i++] = nums[k++];
            ans[i++] = nums[j++];
        }
        return ans;
    }
}