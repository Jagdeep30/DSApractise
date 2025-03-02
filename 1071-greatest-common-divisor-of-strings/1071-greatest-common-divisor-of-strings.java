class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int gcdN = l1>l2?gcd(l1,l2):gcd(l2,l1);
        String ans = "";
        // for(int i=0;i<gcdN;i++){
        //     char c1 = str1.charAt(i);
        //     char c2 = str2.charAt(i);
        //     if(c1!=c2)return "";
        //     ans+=c1;
        // }
        if(str2.startsWith(str1.substring(0,gcdN)))ans = str1.substring(0,gcdN);
        if(ans.equals(""))return ans;
        str1 = str1.replaceAll(ans,"");
        str2 = str2.replaceAll(ans,"");
        // System.out.println(str2);
        if(str1.equals("") && str2.equals(""))return ans;
        return "";
    }
    static int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}