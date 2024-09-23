class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Map<String,Boolean> mp = new HashMap<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<dictionary.length;i++){
            mp.put(dictionary[i],true);
        }
        return solve(s,0,mp,dp);
    }

    static int solve(String s, int i, Map<String,Boolean> mp, int[] dp){
        if(i>=s.length())return 0;

        if(dp[i]!=Integer.MAX_VALUE)return dp[i];

        int extra = Integer.MAX_VALUE;
        String temp = "";

        for(int j=i;j<s.length();j++){
            temp+=s.charAt(j);
            if(mp.getOrDefault(temp,false)){
                extra = Math.min(extra,solve(s,j+1,mp,dp));
            }
        }

        return dp[i] = Math.min(extra,1+solve(s,i+1,mp,dp));
    }
}