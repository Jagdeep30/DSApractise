class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        // for(int i=1;i<=n;i++){
            // ls.add(i);
            find(0,k,n,ls,ans);
            // ls.remove(0);
        // }
        return ans;
    }
    static void find(int i, int k, int n, List<Integer> ls, List<List<Integer>> ans){
        if(k==0){
            ans.add(new ArrayList<Integer>(ls));
            return;
        }

        for(int j=i+1;j<=n;j++){
            ls.add(j);
            find(j,k-1,n,ls,ans);
            ls.remove(ls.size()-1);
        }
        return;
    }
}