class Solution {
    public int[] rearrangeArray(int[] nums) {
        // List<Integer> pos = new ArrayList<>();
        // List<Integer> neg = new ArrayList<>();

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>=0)pos.add(nums[i]);
        //     else neg.add(nums[i]);
        // }

        int n = nums.length;
        int j=0;
        int k=1;
        int[] ans = new int[n];
        // for(int i=0;i<n;i++){
        //     if((i&1)==0){
        //         nums[i] = pos.get(j++);
        //     }
        //     else{
        //         nums[i] = neg.get(k++);
        //     }
        // }
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                ans[j] = nums[i];
                j+=2;
            }
            else{
                ans[k] = nums[i];
                k+=2;
            }
        }

        // return nums;
        return ans;
    }
}