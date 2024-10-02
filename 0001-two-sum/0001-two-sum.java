class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int req = mp.getOrDefault(target-nums[i],-1);
            if(req!=-1 && req!=i)return new int[]{i,req};
        }
        return new int[0];
    }
}