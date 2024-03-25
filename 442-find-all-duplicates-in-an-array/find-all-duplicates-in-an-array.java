class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Map<Integer,Integer> mp = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        // }

        // List<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> e:mp.entrySet()){
        //     if(e.getValue()==2){
        //         ans.add(e.getKey());
        //     }
        // }

        // return ans;

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = Math.abs(nums[i])-1;
            if(nums[n]<0){
                ans.add(n+1);
            }
            else{
                nums[n]*=-1;
            }
        }

        return ans;
    }
}