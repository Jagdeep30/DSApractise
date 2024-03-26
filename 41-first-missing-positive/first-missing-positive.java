class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1]){
                int t = nums[i]-1;

                if(t<n && t>=0){
                    int temp = nums[t];
                    nums[t] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        // System.out.println(Arrays.toString(nums));

        for(int i=0;i<n;i++){
            if(nums[i]-1!=i)return i+1;
        }

        return n+1;
    }
}