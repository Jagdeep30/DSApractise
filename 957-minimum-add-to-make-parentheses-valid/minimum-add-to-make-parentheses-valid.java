class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans =  0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(ch);
                continue;
            }

            if(st.isEmpty()){
                ans++;
                continue;
            }

            st.pop();
        }

        if(!st.isEmpty())ans+=st.size();

        return ans;
    }
}