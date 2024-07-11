class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                String temp = "";
                while(!st.peek().equals("(")){
                    String p = st.pop();
                    if(p.length()>1){
                        temp += new StringBuilder(p).reverse().toString();
                    }
                    else{
                        temp += p;
                    }
                }
                st.pop();
                st.push(temp);
            }
            else{
                st.push(ch+"");
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += new StringBuilder(st.pop()).reverse().toString();
        }
        return new StringBuilder(ans).reverse().toString();
    }
}