class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp  = new HashMap<>();
        int i=0;
        int j=1;
        int n = s.length();
        if(n==0 || n==1)return n;
        int max = 1;
        mp.put(s.charAt(0),0);
        // mp.put(s.charAt(1),1);
        while(i<n && j<n){
            while(j<n && mp.getOrDefault(s.charAt(j),-1)==-1){
                mp.put(s.charAt(j),j);
                j++;
            }
            max = Math.max(max,j-i);
            if(j>=n)break;

            int temp = mp.get(s.charAt(j))+1;
            while(i<temp){
                mp.put(s.charAt(i),-1);
                i++;
            }
            mp.put(s.charAt(j),j);
            j++;
        }

        return max;
    }
}