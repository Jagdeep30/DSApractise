class Solution {
    public void sortColors(int[] nums) {
        //sort 0,2
        int i=0;
        int j=nums.length-1;
        int temp;

        while(i<j){
            while(i<nums.length && nums[i]!=2){
                i++;
            }
            while(j>=0 && nums[j]!=0){
                j--;
            }
            if(i>=j)break;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // sort 1,2
        i=0;
        j=nums.length-1;

        while(i<j){
            while(i<nums.length && nums[i]!=2){
                i++;
            }
            while(j>=0 && nums[j]!=1){
                j--;
            }
            if(i>=j)break;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // sort 0,1
        i=0;
        j=nums.length-1;

        while(i<j){
            while(i<nums.length && nums[i]!=1){
                i++;
            }
            while(j>=0 && nums[j]!=0){
                j--;
            }
            if(i>=j)break;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        return;
    }
}