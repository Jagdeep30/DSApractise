class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        int n = s.length();
        int m = t.length();

        while(i<n && j<m){
            char sc = s.charAt(i);
            char tc = t.charAt(j);

            if(sc == tc){
                j++;
            }
            i++;
        }

        return m-j;
    }
}