class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        int ans = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                ans++;
                nums[i+1]++;
            }
            else if(nums[i]>nums[i+1]){
                ans+=nums[i]-nums[i+1]+1;
                nums[i+1]+=nums[i]-nums[i+1]+1;
            }
        }


        return ans;
    }
}