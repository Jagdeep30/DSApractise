class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            List<Integer> p = mp.getOrDefault(nums1[i], new ArrayList<Integer>());
            p.add(1);
            p.add(0);
            mp.put(nums1[i],p);
        }

        for(int i=0;i<nums2.length;i++){
            List<Integer> p = mp.getOrDefault(nums2[i], new ArrayList<Integer>());
            if(p.size()==0){
                p.add(0);
                p.add(1);
            }
            else p.set(1,1);

            mp.put(nums2[i], p);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());

        for(Map.Entry<Integer,List<Integer>> e: mp.entrySet()){
            int val = e.getKey();
            List<Integer> temp = e.getValue();
            if(temp.get(0)==1 && temp.get(1)==0){
                ans.get(0).add(val);
            }
            if(temp.get(1)==1 && temp.get(0)==0){
                ans.get(1).add(val);
            }
        }
        return ans;
    }
}