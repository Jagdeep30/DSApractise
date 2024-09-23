class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        for(int i=0;i<dictionary.length;i++){
            if(s.contains(dictionary[i])){
                s=s.replace(dictionary[i],"");
            }
        }
        return s.length();
    }
}