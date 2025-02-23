class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        int n=s.length();
        int m=t.length();
        while(i<n && j<m){
            char c = s.charAt(i);
            char ch = t.charAt(j);
            if(c==ch){
                i++;
            }
            j++;
        }
        if(i==n)return true;
        return false;
    }
}