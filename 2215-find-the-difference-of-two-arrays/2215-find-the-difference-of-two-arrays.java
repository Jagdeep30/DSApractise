class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer,Boolean> mp1 = new HashMap<>();
        Map<Integer,Boolean> mp2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            mp1.put(nums1[i], true);
        }
        for(int i=0;i<nums2.length;i++){
            mp2.put(nums2[i], true);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());

        for(Map.Entry<Integer,Boolean> e : mp1.entrySet()){
            if(!mp2.getOrDefault(e.getKey(), false)){
                ans.get(0).add(e.getKey());
            }
        }
        for(Map.Entry<Integer,Boolean> e : mp2.entrySet()){
            if(!mp1.getOrDefault(e.getKey(), false)){
                ans.get(1).add(e.getKey());
            }
        }
        return ans;
    }
}