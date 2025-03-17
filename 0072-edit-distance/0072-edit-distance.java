class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,word1,word2,dp);
    }

    static int solve(int i, int j, String word1, String word2, int[][] dp){
        //base case
        if(i==word1.length() && j==word2.length())return 0;
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length())return word1.length()-i;

        if(dp[i][j]!=-1)return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        //choices
        if(word1.charAt(i)==word2.charAt(j))return solve(i+1,j+1,word1,word2,dp);
            //insert
            min = Math.min(min,solve(i,j+1,word1,word2,dp));
            //delete
            min = Math.min(min,solve(i+1,j,word1,word2,dp));
            //replace
            min = Math.min(min,solve(i+1,j+1,word1,word2,dp));

        //return min value
        return dp[i][j] = min+1;
    }
}