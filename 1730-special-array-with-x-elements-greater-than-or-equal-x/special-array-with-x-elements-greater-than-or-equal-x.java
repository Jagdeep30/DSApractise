class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        return solve(nums);
    }

    static int solve(int[] nums){
        int s = 1;
        int e = nums.length;
        int mid = s+(e-s)/2;

        while(s<=e){
            mid = s+(e-s)/2;
            int spec = special(mid,nums);
            if(spec==0){
                return mid;
            }
            else if(spec==1){ //if more numbers
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return -1;
    }

    static int special(int mid, int[] nums){
        int i=0;
        while(i<nums.length && nums[i]<mid){
            i++;
        }
        if(i==nums.length)return -1;
        int res = nums.length - i;

        if(res==mid)return 0;
        else if(res>mid)return 1;
        else return -1;
    }
}