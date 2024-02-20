class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int mid = 0;
        while(s<=e){
            mid = s + (e-s)/2;
            // System.out.print("s->"+s+" "+"e->"+e+" "+"mid->"+mid);
            if(nums[mid]==target)return true;
            else if(nums[s]==nums[mid] && nums[e]==nums[mid]){
                s++;
                e--;
            }
            else{
                if(nums[mid]<=nums[e]){
                    // System.out.println("->right");
                    if(target>=nums[mid] && target<=nums[e]){
                        s = mid + 1;
                    }
                    else{
                        e = mid - 1;
                    }
                }
                else{
                    // System.out.println("->left");
                    if(target>=nums[s] && target<=nums[mid]){
                        e = mid - 1;
                    }
                    else{
                        s = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}