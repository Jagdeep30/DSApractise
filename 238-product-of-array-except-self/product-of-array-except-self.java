class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));
        // suffix[n-1] = 1;
        // for(int i=n-2;i>=0;i--){
        //     suffix[i] = suffix[i+1]*nums[i+1];
        // }

        // int[] ans = new int[n];
        // for(int i=0;i<n;i++){
        //     ans[i] = prefix[i]*suffix[i];
        // }

        int right = 1;
        for(int i=n-2;i>=0;i--){
            prefix[i] = right*nums[i+1]*prefix[i];
            right*=nums[i+1];
        }

        return prefix;
    }
}