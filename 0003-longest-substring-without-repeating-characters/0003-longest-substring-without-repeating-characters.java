class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1)return s.length();
        Map<Character,Boolean> mp = new HashMap<>();
        int i=0;
        int j=0;
        int max = 1;
        while(j<s.length()){
            char c = s.charAt(j);
            if(mp.getOrDefault(c,false)){
                max = Math.max(max,j-i);
                while(i<=j && s.charAt(i)!=c){
                    mp.put(s.charAt(i),false);
                    i++;
                }
                i++;
            }
            mp.put(c,true);
            j++;
        }
        return Math.max(max,j-i);
    }
}