class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i=1;i<n;i++)l[i] = l[i-1]+nums[i-1];
        for(int i=n-2;i>=0;i--)r[i] = r[i+1]+nums[i+1];

        for(int i=0;i<n;i++)nums[i] = Math.abs(l[i]-r[i]);
        return nums;
    }
}