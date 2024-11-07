class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        return solve(0,0,0,s1,s2,s3,dp);
    }

    static boolean solve(int i, int j, int k, String s1, String s2, String s3, int[][][] dp){
        if(i==s1.length()){
            if(s3.substring(k).equals(s2.substring(j)))return true;
            return false;
        }
        if(j==s2.length()){
            if(s3.substring(k).equals(s1.substring(i)))return true;
            return false;
        }
        if(s1.charAt(i)!=s3.charAt(k) && s2.charAt(j)!=s3.charAt(k))return false;

        if(dp[i][j][k]==1)return true;
        if(dp[i][j][k]==2)return false;

        if(s1.charAt(i)==s3.charAt(k)){
            if(solve(i+1,j,k+1,s1,s2,s3,dp)){
                dp[i][j][k] = 1;
                return true;
            }
        }
        if(s2.charAt(j)==s3.charAt(k)){
            if(solve(i,j+1,k+1,s1,s2,s3,dp)){
                dp[i][j][k] = 1;
                return true;
            }
        }
        
        dp[i][j][k] = 2;
        return false;
    }
}