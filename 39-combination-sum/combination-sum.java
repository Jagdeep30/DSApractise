class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // int[][] dp = new int[candidates.length][target+1];
        // for(int i=0;i<dp.length;i++)Arrays.fill(dp[i], -1);
        Set<List<Integer>> output = new HashSet<>();
        solve(0,target,new ArrayList<Integer>(),output,candidates);
        return new ArrayList<List<Integer>>(output);
    }

    static void solve(int i, int target, List<Integer> ls, Set<List<Integer>> output, int[] candidates){
        //base cases
        if(target==0){
            output.add(new ArrayList<Integer>(ls));
            return;
        }
        if(target<0 || i==candidates.length)return;

        // if(dp[i][target]!=-1)return dp[i][target];
        //choose
        ls.add(candidates[i]);
            //choose same again
            solve(i,target-candidates[i],ls,output,candidates);
            //move to next
            solve(i+1,target-candidates[i],ls,output,candidates);
        ls.remove(ls.size()-1);
        //not choose
        solve(i+1,target,ls,output,candidates);

        //ans
        return;
    }
}