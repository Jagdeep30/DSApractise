class Node {
    Node[] arr;
    boolean end;
    Node(){
        arr = new Node[26];
        end = false;
    }
}

class Trie {
    Node start;
    public Trie() {
        start = new Node();
    }
    
    public void insert(String word) {
        Node temp = start;
        int len = word.length();
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            if(temp.arr[c-'a'] == null){
                temp.arr[c-'a'] = new Node();
            }
            temp = temp.arr[c-'a'];
        }
        temp.end = true;
    }
    
    public boolean search(String word) {
        Node temp = start;
        int len = word.length();
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            if(temp.arr[c-'a']==null)return false;
            temp = temp.arr[c-'a'];
        }
        return temp.end;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = start;
        int len = prefix.length();
        for(int i=0;i<len;i++){
            char c = prefix.charAt(i);
            if(temp.arr[c-'a']==null)return false;
            temp = temp.arr[c-'a'];
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