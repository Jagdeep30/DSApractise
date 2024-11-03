class Solution {
    public int singleNumber(int[] nums) {
        //APPROACH 1
        // int ans = 0;
        // for(int i=0;i<32;i++){
        //     int c = 0;
        //     for(int j=0;j<nums.length;j++){
        //         if((nums[j] & (1<<i))!=0)c++;
        //     }
        //     if(c%3!=0)ans |= (1<<i);
        // }
        // return ans;

        //APPROACH 2
        Arrays.sort(nums);
        int i=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1])return nums[i-1];
            i+=3;
        }
        return nums[nums.length-1];
    }
}