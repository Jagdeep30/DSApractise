class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            if(mp.get(nums[i])>n/3)st.add(nums[i]);
        }

        for(Integer i:st){
            ans.add(i);
        }
        return ans;
    }
}