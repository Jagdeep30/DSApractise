class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        solve(0, ls, new ArrayList<Integer>(),nums);
        return ls;
    }

    static void solve(int i, List<List<Integer>> ls, List<Integer> out, int[] nums){
        if(i==nums.length){
            ls.add(new ArrayList<Integer>(out));
            return;
        }

        solve(i+1,ls,out,nums);
        out.add(nums[i]);
        solve(i+1,ls,out,nums);
        out.remove(out.size()-1);
        return;
    }
}