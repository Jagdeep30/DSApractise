class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // return tabulation(nums,goal);

       return atMost(nums,goal)-atMost(nums,goal-1);
    }

    static int atMost(int[] nums, int goal){
        int i=0;
        // int j=0;
        int count = 0;
        int sum = 0;

        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>goal && i<=j){
                sum-=nums[i];
                i++;
            }

            count += j-i+1;
        }

        return count;
    }

    // static int tabulation(int[] nums, int goal){
    //     int n = nums.length;
    //     int[][] dp = new int[n][n];

    //     //base case
    //     dp[0][0] = nums[0];
    //     for(int i=1;i<n;i++){
    //         dp[0][i] = dp[0][i-1]+nums[i];
    //     }

    //     for(int i=1;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             dp[i][j] = dp[i-1][j]-nums[i-1];
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         System.out.println(Arrays.toString(dp[i]));
    //     }

    //     int count = 0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(dp[i][j]==goal)count++;
    //         }
    //     }

    //     return count;
    // }
}