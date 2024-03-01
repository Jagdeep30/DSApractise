class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zero = 0;
        int one = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='0')zero++;
            else one++;
        }

        String ans = "";
        while(one--!=1)ans+="1";
        while(zero--!=0)ans+="0";
        ans+="1";
        return ans;
    }
}