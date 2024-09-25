class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int i=0;
        int j=0;
        int n=s.length();
        int max = 0;
        // mp.put(s.charAt(0),1);
        while(i<n && j<n && i<=j){
            while(j<n && mp.getOrDefault(s.charAt(j),0)==0){
                mp.put(s.charAt(j),1);
                j++;
            }
            // System.out.println(i+"  "+j);
            max = Math.max(max,j-i);
            while(i<j && i<n && j<n && s.charAt(i)!=s.charAt(j)){
                mp.put(s.charAt(i),0);
                i++;
            }
            i++;
            j++;
        }
        max = Math.max(max,j-i);
        return max;
    }
}