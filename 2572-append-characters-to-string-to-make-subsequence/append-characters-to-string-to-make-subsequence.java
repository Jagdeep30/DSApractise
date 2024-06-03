class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;

        while(i<s.length() && j<t.length()){
            char sc = s.charAt(i);
            char tc = t.charAt(j);

            if(sc == tc){
                i++;
                j++;
            }
            else i++;
        }

        if(j==t.length())return 0;
        else return t.length()-j;
    }
}