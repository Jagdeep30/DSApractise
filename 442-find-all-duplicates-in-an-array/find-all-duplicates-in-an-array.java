class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            if(e.getValue()==2){
                ans.add(e.getKey());
            }
        }

        return ans;
    }
}