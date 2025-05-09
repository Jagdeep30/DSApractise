class Solution {
    public int longestValidParentheses(String s) {
        int o = 0;
        int c = 0;
        int max = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                o++;
            }
            if(ch==')'){
                c++;
            }

            if(o==c){
                max = Math.max(max,o+c);
            }

            if(c>o){
                c=0;
                o=0;
            }
        } 
        o = 0;
        c=0;
        int max2 = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch==')'){
                o++;
            }
            if(ch=='('){
                c++;
            }

            if(o==c){
                max2 = Math.max(max2,o+c);
            }

            if(c>o){
                c=0;
                o=0;
            }
        }


        return Math.max(max,max2);
    }
}