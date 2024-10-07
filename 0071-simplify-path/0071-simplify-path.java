class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/{1,}");
        // System.out.println(Arrays.toString(arr));
        Stack<String> st = new Stack<>();
        // st.push("/");
        for(int i=1;i<arr.length;i++){
            if(arr[i].equals("..")){
                if(!st.isEmpty())
                st.pop();
            }
            else if(arr[i].equals(".")){
                continue;
            }
            else{
                st.push(arr[i]);
                // st.push("/");
            }
        }
        // if(st.peek()=="/")
        List<String> ls = new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        // Collections.reverse(ls);
        String ans = "/";
        for(int i=ls.size()-1;i>=0;i--){
            ans+=ls.get(i);
            if(i!=0)ans+="/";

        }
        return ans;
    }
}