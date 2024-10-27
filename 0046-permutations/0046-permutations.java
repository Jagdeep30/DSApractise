class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++)ls.add(nums[i]);
        List<List<Integer>> ans = new ArrayList<>();
        find(0,ls,ans);
        return ans;
    }
    static void find(int i, List<Integer> ls, List<List<Integer>> ans){
        if(i==ls.size()-1){
            ans.add(new ArrayList<Integer>(ls));
            return;
        }

        for(int j=i;j<ls.size();j++){
            int t = ls.get(i);
            ls.set(i,ls.get(j));
            ls.set(j,t);
            find(i+1,ls,ans);
            t = ls.get(i);
            ls.set(i,ls.get(j));
            ls.set(j,t);
        }
        return;
    }
}