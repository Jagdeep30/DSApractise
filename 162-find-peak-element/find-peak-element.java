class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int s = 0;
        int e = n-1;
        int mid = 0;

        while(s<e){
            mid = s + (e-s)/2;
            if(nums[mid+1]>nums[mid]){
                s = mid+1;
            }
            else{
                e=mid;
            }
        }
        if(s==e)return s;
        return -1;
    }
}