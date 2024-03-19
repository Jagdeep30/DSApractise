class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,target,candidates,candidates.length,new ArrayList<>(), ans);
        return ans;
    }

    static void solve(int i, int target, int[] candidates, int n, List<Integer> output, List<List<Integer>> ans){
        if(target==0){
            if(!ans.contains(output))
            ans.add(new ArrayList<>(output));
            return;
        }
        if(i==n){
            // if(!ans.contains(output))
            // ans.add(new ArrayList<>(output));
            return;
        }
        if(target<0)return;

        //exclude
        solve(i+1,target,candidates,n,output,ans);
        //include
        output.add(candidates[i]);
        solve(i,target-candidates[i],candidates,n,output,ans);
        output.remove(new Integer(candidates[i]));

        return;
    }
}