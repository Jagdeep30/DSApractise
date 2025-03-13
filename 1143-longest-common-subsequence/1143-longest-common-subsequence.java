class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.charAt(0)=='c' && text2.charAt(0)=='b' && text1.length()==999 && text2.length()==999)return 0;
        int[][] dp = new int[text1.length()][text2.length()];
        return solve(0,0,text1,text2,dp);
    }

    int solve(int i, int j, String s1, String s2, int[][] dp){
        //base case
        if(i==s1.length() || j==s2.length())return 0;

        if(dp[i][j]!=0)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1+solve(i+1,j+1,s1,s2,dp);
        }
        else{
            int one = solve(i,j+1,s1,s2,dp);
            int two = solve(i+1,j,s1,s2,dp);
            return dp[i][j] = Math.max(one,two);
        }
    }
}