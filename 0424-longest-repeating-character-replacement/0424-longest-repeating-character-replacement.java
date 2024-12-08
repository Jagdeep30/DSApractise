class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int maxf = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int[] f = new int[26];

        while(j<s.length()){
            f[s.charAt(j)-'A']++;
            maxf = Math.max(maxf,f[s.charAt(j)-'A']);
            if(j-i+1 - maxf <= k)ans = Math.max(ans, j-i+1);
            else {
                // while(i<j){
                    f[s.charAt(i)-'A']--;
                    i++;
                    // maxf = maxFreq(f);
                    // if(j-i+1 - maxf <= k){
                    //     // ans = Math.max(ans,j-i+1);
                    //     break;
                    // }
                // }
            }
            j++;
        }
        return ans;
    }
    static int maxFreq(int[] f){
        int max = 0;
        for(int i=0;i<26;i++){
            max = Math.max(max,f[i]);
        }
        return max;
    }
}