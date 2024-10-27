class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        find(0,target,ls,ans,candidates);
        return ans;
    }
    static void find(int i, int target, List<Integer> ls, List<List<Integer>> ans, int[] candidates){
        if(target==0){
            ans.add(new ArrayList<Integer>(ls));
            return;
        }
        if(target<0 || i==candidates.length)return;

        for(int j=i;j<candidates.length;j++){
            if(target<candidates[j])continue;
            ls.add(candidates[j]);
            find(j,target-candidates[j],ls,ans,candidates);
            ls.remove(ls.size()-1);
        }
        return;
    }
}