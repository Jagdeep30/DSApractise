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