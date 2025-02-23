class Solution {
    public void moveZeroes(int[] nums) {
        int z=0;
        int o=0;
        int n=nums.length;
        while(z<n && o<n){
            while(z<n && nums[z]!=0)z++;
            while(o<n && z<=o && nums[o]==0)o++;
            if(z>=n || o>=n)return;
            if(o<z){
                o++;continue;
            }
            nums[z] = nums[o];
            nums[o] = 0;
            // System.out.println(Arrays.toString(nums));
        }
        return;
    }
}