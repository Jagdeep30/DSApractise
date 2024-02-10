class Solution {
    public int countSubstrings(String s) {
        int count  = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(j==i){
                    count++;
                    continue;
                }
                String curr = s.substring(i,j+1);
                String rev = (new StringBuilder(curr)).reverse().toString();
                if(curr.equals(rev))count++;
            }
        }
        return count;
    }
}