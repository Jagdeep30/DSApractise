class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int ele = mp.getOrDefault(target-nums[i],-1);
            if(ele != -1){
                return new int[]{i,ele};
            }
            mp.put(nums[i], i);
        }

        return new int[0];
    }
}