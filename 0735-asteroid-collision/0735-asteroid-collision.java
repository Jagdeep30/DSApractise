class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        // while(j<arr.length && arr[j]<0){
        //     j++;
        // }
        for(int i=j;i<arr.length;i++){
            int ele = arr[i];
            if(st.isEmpty())st.push(ele);
            else if((ele<=0 && st.peek()<=0)||(ele>0 && st.peek()>0)){
                st.push(ele);
            }
            else{
                boolean add = true;
                int top = 1001;
                while(!st.isEmpty()){
                    top = st.peek();
                    if(top<0)break;
                    if(Math.abs(top) > Math.abs(ele)){
                        add = false;
                        break;
                    }
                    else if(Math.abs(top) < Math.abs(ele))st.pop();
                    else{
                        add = false;
                        st.pop();
                        break;
                    }
                }
                if(add)st.push(ele);
            }
        }
        // System.out.println(st);
        int[] ans = new int[st.size()];
        // for(int i=0;i<j;i++){
        //     ans[i] = arr[i];
        // }
        for(int i=ans.length-1;i>=j;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}