class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean valid = true;
        int ss = 0;
        int max = Integer.MIN_VALUE;
        for(int e=0;e<s.length();e++){
            if(freq[s.charAt(e)-'a']>=0 && freq[s.charAt(e)-'a']<k){
                String nw = s.substring(ss,e);
                max = Math.max(max,longestSubstring(nw,k));
                ss = e + 1;
                valid = false;
            }
        }
        if(valid)return s.length();
        return Math.max(max,longestSubstring(s.substring(ss),k));
    }
}