class Solution {
    public void nextPermutation(int[] nums) {
        //find the breakpoint
        int n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }

        if(index==-1){
            int s=0;
            int e=n-1;
            while(s<e){
                int temp = nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;e--;
            }
            return ;
        }

        int ele = Integer.MAX_VALUE;
        int ind = -1;
        for(int i=index+1;i<n;i++){
            if(nums[i]>nums[index] && nums[i]<ele)ind=i;
        }

        int temp = nums[ind];
        nums[ind]=nums[index];
        nums[index]=temp;


        int s=index+1;
        int e=n-1;
        while(s<e){
            int tempp = nums[s];
            nums[s]=nums[e];
            nums[e]=tempp;
            s++;e--;
        }

        return ;

    }
}