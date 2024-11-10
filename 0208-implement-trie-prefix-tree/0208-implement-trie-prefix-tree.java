class Trie {
    Trie[] t;
    boolean end;
    public Trie() {
        t = new Trie[26];
        end = false;
    }
    
    public void insert(String word) {
        Trie[] temp = t;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(temp[ind]==null){
                temp[ind] = new Trie();
            }
            if(!temp[ind].end)temp[ind].end = i==word.length()-1?true:false;
            temp = temp[ind].t;
        }
        // temp.end = true;
        return;
    }
    
    public boolean search(String word) {
        Trie[] temp = t;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(temp[ind]==null)return false;
            if(i==word.length()-1 && temp[ind].end==true)return true;
            temp = temp[ind].t;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie[] temp = t;
        for(int i=0;i<prefix.length();i++){
            int ind = prefix.charAt(i)-'a';
            if(temp[ind]==null)return false;
            temp = temp[ind].t;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */