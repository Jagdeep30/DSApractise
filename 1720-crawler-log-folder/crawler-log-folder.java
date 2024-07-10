class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(String s:logs){
            // System.out.println(st);
            String[] arr = s.split("/");
            // System.out.println(Arrays.toString(arr));
            if(arr[0].equals(".")){
                continue;
            }
            else if(arr[0].equals("..")){
                if(st.peek()!=-1)st.pop();
            }
            else{
                st.push(1);
            }
        }
        int ans = 0;
        while(st.peek()!=-1){
            ans+=st.pop();
        }
        return ans;
    }
}