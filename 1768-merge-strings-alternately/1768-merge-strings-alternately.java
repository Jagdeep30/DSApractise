class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int i=0;
        int j=0;
        while(i<word1.length() && j<word2.length()){
            ans+=word1.charAt(i++);
            ans+=word2.charAt(j++);
        }
        // while(i<word1.length()){
        //     ans+=word1.charAt(i++);
        // }
        // while(j<word2.length()){
        //     ans+=word2.charAt(j++);
        // }
        ans+=word1.substring(i);
        ans+=word2.substring(j);

        return ans;
    }
}