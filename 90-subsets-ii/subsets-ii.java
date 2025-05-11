class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ls = new HashSet<>();
        solve(0, ls, new ArrayList<Integer>(),nums);
        // System.out.println(ls);
        return new ArrayList<List<Integer>>(ls);
    }

    static void solve(int i, Set<List<Integer>> ls, List<Integer> out, int[] nums){
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