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

        StringBuilder nw = new StringBuilder(word.substring(0,ind+1)).reverse();
        return nw.append(word.substring(ind+1)).toString();
    }
}