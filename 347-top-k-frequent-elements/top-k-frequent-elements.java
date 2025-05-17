class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        Map<Integer,List<Integer>> mpp = new HashMap<>();
        for(Map.Entry<Integer,Integer> e: mp.entrySet()){
            List<Integer> ls = mpp.getOrDefault(e.getValue(), new ArrayList<Integer>());
            ls.add(e.getKey());
            mpp.put(e.getValue(), ls);
        }

        List<Integer> ls = new ArrayList<>();
        int l = 0;
        for(int i=nums.length+1;i>=0;i--){
            List<Integer> t = mpp.getOrDefault(i,null);
            if(t==null)continue;

            for(Integer j: t){
                ls.add(j);
                l++;
                if(l==k)break;
            }

            if(l==k)break;
        }

        int[] ans = new int[ls.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = ls.get(i);
        }

        return ans;

    }
}