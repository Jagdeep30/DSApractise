class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        if(s.length()<3)return 0;
        String t = s.substring(0,3);
        int[] f = new int[26];
        f[t.charAt(0)-'a']++;
        f[t.charAt(1)-'a']++;
        f[t.charAt(2)-'a']++;
        for(int i=3;i<s.length();i++){
            // System.out.println(t);
            // System.out.println(Arrays.toString(f));
            if(f[t.charAt(0)-'a']==1 && f[t.charAt(1)-'a']==1 && f[t.charAt(2)-'a']==1){
                ans++;
            }
            f[t.charAt(0)-'a']--;
            f[s.charAt(i)-'a']++;
            t = t + s.charAt(i);
            t = t.substring(1);
        }
        if(f[t.charAt(0)-'a']==1 && f[t.charAt(1)-'a']==1 && f[t.charAt(2)-'a']==1){
                ans++;
            }
        return ans;
    }
}