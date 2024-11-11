class WordDictionary {
    WordDictionary[] arr;
    boolean end;
    public WordDictionary() {
        arr = new WordDictionary[26];
        end = false;
    }
    
    public void addWord(String word) {
        WordDictionary[] temp = arr;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(temp[ind]==null){
                temp[ind] = new WordDictionary();
            }
            if(i==word.length()-1 && !temp[ind].end)temp[ind].end = true;
            temp = temp[ind].arr;
        }
        return;
    }
    
    public boolean search(String word) {
        WordDictionary[] temp = arr;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(word.charAt(i)=='.'){
                WordDictionary[] t2 = temp;
                for(int j=0;j<26;j++){
                    if(t2[j]!=null){
                        boolean res = this.search(word.substring(0,i)+((char)('a'+j))+word.substring(i+1));
                        if(res)return true;
                    }
                }
                return false;
            }
            else if(temp[ind]==null){
                return false;
            }else{
                if(i==word.length()-1 && temp[ind].end)return true;
                temp = temp[ind].arr;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */