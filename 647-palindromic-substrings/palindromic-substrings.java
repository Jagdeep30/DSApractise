class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        //length 1 palindromes
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            ans++;
        }

        //length 2 palindromes
        for(int i=0;i<=n-2;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                ans++;
            }
        }

        //length greater than 2 palindromes
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}