class Solution {
    public int numDecodings(String s) {
        if(s.equals("0"))return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        // dp[0] = 1;
        Map<String,Character> mp = new HashMap<>();
        for(int i=1;i<=26;i++)mp.put(Integer.toString(i), (char)('A'+i-1));
        // System.out.println(mp);
        return solve(0, mp, s, dp);

        // for(int i=1;i<s.length();i++){

        // }
    }

    static int solve(int i, Map<String,Character> mp, String s, int[] dp){
        //base case
        if(i==s.length()-1){
            return s.charAt(i)=='0'?0:1;
        }
        if(i>=s.length()){
            return 1;
        }
        if(s.charAt(i)=='0')return 0;
        // temp+=s.charAt(i);
        if(dp[i]!=-1)return dp[i];
        //choose
        // char t = mp.getOrDefault(temp, '#');
        // if(t == '#')return 0;
        int r1 = solve(i+1,mp,s,dp);
        //move-on
        int r2 = 0;
        if(Integer.parseInt(s.substring(i,i+2))<=26){
            r2 = solve(i+2,mp,s,dp);
        }

        return dp[i] = r1+r2; 
    }
}