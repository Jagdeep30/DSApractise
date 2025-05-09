class Solution {
    public int minAddToMakeValid(String s) {
        int o = 0;
        int c = 0;
        int ans =  0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                o++; 
                continue;
            }

            if(o==0){
                ans++;
                continue;
            }

            o--;
        }

        if(o!=0)ans+=o;

        return ans;
    }
}