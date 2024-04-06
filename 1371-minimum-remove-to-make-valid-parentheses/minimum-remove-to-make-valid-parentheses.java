class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(ch=='('){
                left++;
            }
            else if(ch==')'){
                if(left>0)left--;
                else{
                    arr[i] = '*';
                }
            }
        }

        for(int i=arr.length-1;i>=0;i--){
            if(left>0 && arr[i]=='('){
                arr[i] = '*';
                left--;
            }
            else if(left<=0)break;
        }

        String ans = "";
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*')ans+=arr[i];
        }
        return ans;
    }
}