class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
                // System.out.println(st);
            char ch = s.charAt(i);
            if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || ch=='[')st.push(String.valueOf(ch));
            else{
                //closed bracket
                String let = "";
                while(!st.isEmpty() && !st.peek().equals("[")){
                    let = st.pop() + let;
                }
                st.pop();
                //check for digits
                String dig = "";
                while(!st.isEmpty() && (st.peek().equals("0") || st.peek().equals("1") || st.peek().equals("2") || st.peek().equals("3") || st.peek().equals("4") || st.peek().equals("5") || st.peek().equals("6") || st.peek().equals("7") || st.peek().equals("8") || st.peek().equals("9"))){
                    dig = st.pop() + dig;
                }
                int mul = dig!=""?Integer.parseInt(dig):1;
                // System.out.println(let);
                String temp = new String(let);
                for(int j=1;j<mul;j++)let+=temp;

                // System.out.println(let);
                st.push(let);

            }
        }
        // System.out.println(st);
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}