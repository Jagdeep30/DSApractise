class Node{
    Node[] arr;
    boolean end;
    Node(){
        arr = new Node[26];
        end = false;
    }

    void insert(String word){
        Node temp = this;
        int len = word.length();
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            if(temp.arr[c-'a']==null)temp.arr[c-'a'] = new Node();
            temp = temp.arr[c-'a'];
        }
        temp.end = true;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node start = new Node();
        for(int i=0;i<products.length;i++){
            start.insert(products[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        int n = searchWord.length();
        for(int i=0;i<n;i++){
            List<String> ls = new ArrayList<>();
            search(ls, start, searchWord.substring(0,i+1));
            
            ans.add(ls);
        }
        return ans;
    }

    static void search(List<String> ls, Node start, String s){
        int n = s.length();
        Node temp = start;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(temp.arr[c-'a']==null)return;
            temp = temp.arr[c-'a'];
        }
        // int c = 0;
        // String t = new String(s);
        // Node it = temp;
        // for(int i=0;i<26;i++){
        //     if(it.arr[i]!=null){

        //     }
        // }
        findWord(s,temp,ls);
        
        return;
    }

    static void findWord(String s, Node node, List<String> ls){
        if(ls.size()==3)return;
        if(node == null)return;
        if(node.end == true){
            ls.add(new String(s));
            // System.out.println(ls);
        }

        for(int i=0;i<26;i++){
            if(ls.size()==3)break;
            if(node.arr[i]!=null){
                findWord(s+((char)('a'+i)), node.arr[i], ls);
            }
        }

        return;
    }
}