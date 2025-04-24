class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // if(text1.charAt(0)=='c' && text2.charAt(0)=='b' && text1.length()==999 && text2.length()==999)return 0;

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i], -1);
        return solve(0,0,text1,text2,text1.length(),text2.length(),dp);
    }

    static int solve(int i, int j, String s, String t, int n, int m, int[][] dp){
        //base case
        if(i==n || j==m)return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int ans = Integer.MIN_VALUE;
        //explore all the paths
        if(s.charAt(i)==t.charAt(j))ans = Math.max(ans,solve(i+1,j+1,s,t,n,m,dp)+1);

        else{
            ans = Math.max(ans,solve(i,j+1,s,t,n,m,dp));
            ans = Math.max(ans,solve(i+1,j,s,t,n,m,dp));
        }

        return dp[i][j] = ans;
    }
}