class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String output = "";
        solve(ans,output,n,n,n);
        return ans;
    }

    static void solve(List<String> ans, String output, int n, int open, int close){
        //base case
        if(open==0 && close==0){
            String temp = output;
            ans.add(temp);
            return;
        }

        //processing


        //call for open bracket
        if(open!=0 && open<=close){
            output+='(';
            solve(ans,output,n,open-1,close);
            output = output.substring(0,output.length()-1);
        }

        //call for closed bracket
        if(close!=0 && close!=open){
            output+=')';
            solve(ans,output,n,open,close-1);
            output = output.substring(0,output.length()-1);
        }

        return ;
    }
}