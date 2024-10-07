class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }
            else if(arr[i]=='}' && !st.isEmpty() && st.peek()=='{'){
                st.pop();
            }
            else if(arr[i]==']' && !st.isEmpty() && st.peek()=='['){
                st.pop();
            }
            else if(arr[i]=='(' || arr[i]=='{' || arr[i]=='['){
                st.push(arr[i]);
            }
            else return false;
        }
        return true;
    }
}