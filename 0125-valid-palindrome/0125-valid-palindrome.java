class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='A' && arr[i]<='Z'){
                temp+= (char)(arr[i]+32);
            }
            else if((arr[i]>='a' && arr[i]<='z') || (arr[i]>='0' && arr[i]<='9')){
                temp+=arr[i];
            }
        }
        int i=0;
        int j=temp.length()-1;
        // System.out.println(temp);
        while(i<j){
            if(temp.charAt(i)==temp.charAt(j)){
                i++;j--;
                continue;
            }
            return false;
        }
        return true;
    }
}