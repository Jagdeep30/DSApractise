class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> arr = mp.getOrDefault(nums[i],new ArrayList<Integer>());
            arr.add(i);
            mp.put(nums[i],arr);
        }

        for(Map.Entry<Integer,List<Integer>> e:mp.entrySet()){
            List<Integer> arr = e.getValue();
            if(arr.size()<2)continue;
            for(int i=0;i<arr.size()-1;i++){
                if(arr.get(i+1)-arr.get(i)<=k)return true;
            }
        }
        return false;
    }
}