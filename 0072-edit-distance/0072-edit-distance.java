class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return solve(0,0,word1,word2,dp);
    }

    static int solve(int i, int j, String word1, String word2, int[][] dp){
        if(j==word2.length())return word1.length()-i;
        if(i==word1.length())return word2.length()-j;

        if(dp[i][j]!=-1)return dp[i][j];

        int min = 1000000;
        if(word1.charAt(i)==word2.charAt(j))min = Math.min(min,solve(i+1,j+1,word1,word2,dp));
        else{
            //insert
            min = Math.min(min,solve(i,j+1,word1,word2,dp)+1);
            //delete
            min = Math.min(min,solve(i+1,j,word1,word2,dp)+1);
            //replace
            min = Math.min(min,solve(i+1,j+1,word1,word2,dp)+1);
        }

        return dp[i][j] = min;
    }
}