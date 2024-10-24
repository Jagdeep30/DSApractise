class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(ans,output,n,k,1);
        return ans;
    }

    static void solve(List<List<Integer>> ans, List<Integer> output, int n, int k, int index){
        //base case
        if(k==0){
            List<Integer> temp = new ArrayList<>(output);
            ans.add(temp);
            return;
        }

        //processing
        for(int i = index;i<=n;i++){
            output.add(i);
            // System.out.print(output);
            solve(ans,output,n,k-1,i+1);
            output.remove(output.size()-1);
            // System.out.println();
        }
        return ;
    }
}