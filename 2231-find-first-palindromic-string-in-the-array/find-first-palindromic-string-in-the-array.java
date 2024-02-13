class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(isPalindrome(words[i]))return words[i];
        }
        return "";
    }

    static boolean isPalindrome(String word){
        int s = 0;
        int e = word.length()-1;
        while(s<e){
            if(word.charAt(s)!=word.charAt(e))return false;
            s++;
            e--;
        }
        return true;
    }
}