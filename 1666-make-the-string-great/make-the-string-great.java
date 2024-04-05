class Solution {
    public String makeGood(String s) {
        int i=0;
        while(i+1<s.length()){
            char next = (char)(s.charAt(i+1));
            if(s.charAt(i)==next+32 || s.charAt(i)==next-32){
                s = s.substring(0,i) + s.substring(i+2);
                if(i-1>=0)i--;
            }
            else{
                i++;
            }
        }

        return s;
    }
}