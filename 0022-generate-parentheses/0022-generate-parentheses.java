class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,n,ans,"");
        return ans;
    }

    static void generate(int o, int c, int n, List<String> ans, String st){
        if(c>o || c>n || o>n || st.length()>n*2)return;
        if(st.length() == n*2 && o==n && c==n){
            ans.add(new String(st));
            return;
        }

        //choose open
        if(o<n){
            generate(o+1,c,n,ans,st+"(");
        }

        //choose close
        if(c<o && c<n){
            generate(o,c+1,n,ans,st+")");
        }

        return;
    }
}