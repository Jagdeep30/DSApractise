class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> mp = new HashMap<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,3);
        for(String i:wordDict){
            mp.put(i,true);
        }
        return solve(0,s,mp,dp);
    }
    static boolean solve(int i, String s, Map<String,Boolean> mp, int[] dp){
        //base case
        if(i==s.length())return true;

        if(dp[i]==1)return true;
        if(dp[i]==0)return false;

        String temp = "";
        boolean ans = false;
        for(int j=i;j<s.length();j++){
            temp+=s.charAt(j);
            if(mp.getOrDefault(temp,false)){
                ans = ans || solve(j+1,s,mp,dp);
            }
            if(ans){
                dp[i] = ans?1:0;
                return ans;
            }
        }
        if(mp.getOrDefault(temp,false))ans = true;
        dp[i] = ans?1:0;
        return ans;
    }
}