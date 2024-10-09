class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a = 0;
        int b = 0;
        for(int i=0;i<tokens.length;i++){
            String t = tokens[i];
            if(t.equals("+")){
                b = st.pop();
                a = st.pop();
                st.push(a+b);
            }
            else if(t.equals("-")){
                b = st.pop();
                a = st.pop();
                st.push(a-b);
            }
            else if(t.equals("*")){
                b = st.pop();
                a = st.pop();
                st.push(a*b);
            }
            else if(t.equals("/")){
                b = st.pop();
                a = st.pop();
                st.push(a/b);
            }
            else{
                int n = Integer.parseInt(t);
                st.push(n);
            }
        }
        return st.pop();
    }
}