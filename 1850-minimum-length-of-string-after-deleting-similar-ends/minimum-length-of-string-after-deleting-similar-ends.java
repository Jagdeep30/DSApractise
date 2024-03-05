class Solution {
    public int minimumLength(String str) {
        String temp = str;

        int s = 0;
        int e = str.length()-1;

        while(s<e){
            // System.out.println(s+"   "+e);
            if(temp.charAt(s)!=temp.charAt(e))return e-s+1;
            s++;
            e--;
            while(s<=e && temp.charAt(s)==temp.charAt(s-1)){
                s++;
            }
            while(s<=e && temp.charAt(e)==temp.charAt(e+1)){
                e--;
            }
            // temp = temp.substring(s,e+1);
        }
        if(s>e)return 0;
        return e-s+1;
    }
}