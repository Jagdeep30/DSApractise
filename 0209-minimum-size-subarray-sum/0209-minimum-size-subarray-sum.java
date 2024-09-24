class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        while(i<n && j<n && i<=j){
            // System.out.println(i+"   "+j+"   min->"+min);
            while(j<n && sum<=target){
                sum+=nums[j];
                if(sum==target)min = Math.min(min,j-i+1);
                j++;
            }
            if(j==n && sum<target){
                if(min==Integer.MAX_VALUE)return 0;
                else return min;
            }
            j--;
            min = Math.min(min,j-i+1);
            // System.out.println("after j-> "+i+"   "+j+"min   "+min);
            while(i<=j && sum>target){
                min = Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            // System.out.println("after i-> "+i+"   "+j+"min   "+min);
            if(sum==target)min = Math.min(min,j-i+1);
            j++;
        }
        // if(sum>=target)min = Math.min(min,j-i);

        return min;
    }
}