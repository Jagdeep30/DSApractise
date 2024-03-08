class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            max = Math.max(max,mp.get(nums[i]));
        }

        int count = 0;
        for(Map.Entry<Integer,Integer> e: mp.entrySet()){
            if(e.getValue()==max)count++;
        }

        return max*count;
    }
}