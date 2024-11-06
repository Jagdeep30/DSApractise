// class Solution {
//     public String longestPalindrome(String s) {
//         boolean[][] dp = new boolean[s.length()][s.length()];
//         int max = Integer.MIN_VALUE;
//         int maxi = 0;
//         int maxj = 0;
//         for(int i=0;i<s.length();i++){
//             for(int j=0;j<s.length();j++){
//                 if(solve(i,j,s,dp) && j-i+1>max){
//                     max = j-i+1;
//                     maxi = i;
//                     maxj = j;
//                 }
//             }
//         }
//         return s.substring(maxi,maxj+1);
//     }

//     static boolean solve(int i, int j, String s, boolean[][] dp){
//         if(i>=j)return true;

//         if(dp[i][j])return dp[i][j];

//         if(s.charAt(i)==s.charAt(j))return dp[i][j] = solve(i+1,j-1,s,dp);
//         return dp[i][j] = false;
//     }
// }

class Solution {
public:
    string longestPalindrome(string s) {
        string ans = "";
        int st=0,e=0;
        int maxL = 1;
        if(s.length()==1)return s;

        for(int i=0;i<s.length();i++){
            int l=i-1;
            int r=i+1;

            //odd length palindrome
            while(l>=0 && r<s.length()){
                if(s[l]!=s[r])break;
                else{
                    l--;
                    r++;
                }
            }
            l++;
            r--;
            if(r-l+1 > maxL){
                maxL = r-l+1;
                st=l;
                e=r;
            }

            //even length palindrome
            l=i-1;
            r=i;
            while(l>=0 && r<s.length()){
                if(s[l]!=s[r])break;
                else{
                    l--;
                    r++;
                }
            }
            l++;
            r--;
            if(r-l+1 > maxL){
                maxL = r-l+1;
                st = l;
                e = r;
            }
        }
        for(int i=st;i<=e;i++){
            ans+=s[i];
        }
        return ans;
    }
};