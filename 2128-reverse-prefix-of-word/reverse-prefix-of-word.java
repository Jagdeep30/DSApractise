class Solution {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        // for(int i=0;i<word.length();i++){
        //     if(word.charAt(i)==ch){
        //         ind=i;
        //         break;
        //     }
        // }


        if(ind==-1)return word;

        String nw = new StringBuilder(word.substring(0,ind+1)).reverse().toString();
        return nw + word.substring(ind+1);
    }
}