class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=1;
        }
        int sum = 0;
        for(int i=1;i<101;i++){
            sum += arr[i]==1?i:0;
        }
        return sum;
    }
}