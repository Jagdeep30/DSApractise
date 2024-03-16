class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums.length,new ArrayList<Integer>(),ans,nums);
        return ans;
    }

    static void solve(int i, int n, List<Integer> output, List<List<Integer>> ans, int[] nums){
        if(i==n){
            ans.add(new ArrayList<Integer>(output));
            return;
        }

        //exclude
        solve(i+1,n,output,ans,nums);

        //include
        output.add(nums[i]);
        solve(i+1,n,output,ans,nums);
        output.remove(new Integer(nums[i]));

        return;
    }
}