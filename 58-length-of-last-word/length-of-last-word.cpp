class Solution {
public:
    int lengthOfLastWord(string s) {
        int l=0;
        int i=s.length()-1;
        if(s[i]==' '){
            while(s[i]==' ')i--;
        }
        while(i>=0 && s[i]!=' '){
            l++;
            i--;
        }
        return l;
    }
};