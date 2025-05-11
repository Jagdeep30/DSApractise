class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       Set<List<Integer>> ls = new HashSet<>();
        solve(0,ls,nums);
        return new ArrayList<List<Integer>>(ls);
    }

    static void solve(int i, Set<List<Integer>> ls, int[] nums){
        if(i==nums.length){
            List<Integer> out = new ArrayList<>();
            for(Integer e: nums){
                out.add(e);
            }
            ls.add(out);
            return;
        }

        for(int j=i;j<nums.length;j++){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            solve(i+1,ls,nums);
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return;
    }
}