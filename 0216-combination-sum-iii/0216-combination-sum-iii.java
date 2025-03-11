class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] visited = new boolean[9];
        List<List<Integer>> ls = new ArrayList<>();
        solve(1,new ArrayList<>(), 0, k, n, ls);
        return ls;
    }

    static void solve(int i, List<Integer> ls, int sum, int k, int n, List<List<Integer>> ans){
        if(k==0 && sum==n){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(i>9){
            return;
        }
        // if(sum>=n){
        //     return;
        // }

        for(int j=i;j<10;j++){
            if(sum+j>n)break;
            ls.add(j);
            solve(j+1,ls,sum+j,k-1,n,ans);
            ls.remove(ls.size()-1);
        }
    }
}