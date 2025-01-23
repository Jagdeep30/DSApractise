class Solution {
    public boolean isMatch(String s, String p) {
        return match(0,0,'_',s,p);
    }

    static boolean match(int i, int j, char prev, String s, String p){
        // if(i==s.length() && j<p.length()){
        if(i==s.length() && j==p.length())return true;
        if(i==s.length()){
            // if(j+1>=p.length() && p.charAt(j)!='*')return false;
            // for(int k=j+1;k<p.length();k+=2){
            //     if(p.charAt(k)!='*')return false;
            // }
            // return true;

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return match(i, j + 2, prev, s, p);
            }
            return false;
        }
        if(i!=s.length() && j==p.length())return false;


        
        if((j+1<p.length() && p.charAt(j+1)=='*')){
            // if(p.charAt(j)=='.')return true;
            // int k=i;
            // char ch = p.charAt(j);
            // if(ch=='.')ch = s.charAt(i);
            // while(k<s.length() && (s.charAt(k)==ch || ch=='.')){
            if(match(i,j+2,prev,s,p))return true;
            if((s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') && match(i+1,j,prev,s,p))return true;
                // k++;
            // }
            // if()return true;
            // return false;
        }
        if((s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') && match(i+1,j+1,prev,s,p))return true;
        // if(i+1<s.length() && s.charAt(i+1)=='*')return match(i,j+1,prev,s,p);
        return false;
    }
}

