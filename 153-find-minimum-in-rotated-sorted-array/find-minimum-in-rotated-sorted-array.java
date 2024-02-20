class Solution {
    public int findMin(int[] nums) {
        //if sorted in ascending order and is not rotated
        int n = nums.length;
        if(nums[0]<nums[n-1])return nums[0];

        int s = 0;
        int e = n-1;
        int mid = 0;
        while(s<e){
            mid = s + (e-s)/2;
            if(nums[mid]>=nums[0]){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }

        return nums[s];
    }
}