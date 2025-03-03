class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='*'){
                st.pop();
            }
            else{
                st.push(ch[i]);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}