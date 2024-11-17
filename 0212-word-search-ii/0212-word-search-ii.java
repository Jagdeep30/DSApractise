class Node{
    Node[] t;
    boolean end;
    Node(){
        t = new Node[26];
        end = false;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node head = new Node();
        Set<String> ans = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<words.length;i++)insert(head, words[i]);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(head.t[board[i][j]-'a']!=null)dfs(i,j,head,board,new StringBuilder(),ans,visited);
            }
        }
        return new ArrayList<String>(ans);
    }

    static void dfs(int i, int j, Node n, char[][] board, StringBuilder temp, Set<String> ans, boolean[][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j])return;
        if(n==null){
            // System.out.println("got n==null at   "+i+"   "+j);
            return;
        }
        if(n.t[board[i][j]-'a']==null)return;
        n = n.t[board[i][j]-'a'];

        // temp += board[i][j];
        temp = temp.append(board[i][j]);
        if(n.end){
            n.end = false;
            ans.add(temp.toString());
        }
        // System.out.println(i+"   "+j);
        visited[i][j] = true;

        //up
        dfs(i-1,j,n,board,temp,ans,visited);
        //right
        dfs(i,j+1,n,board,temp,ans,visited);
        //down
        dfs(i+1,j,n,board,temp,ans,visited);
        //left
        dfs(i,j-1,n,board,temp,ans,visited);

        visited[i][j] = false;
        temp = temp.deleteCharAt(temp.length()-1);

        return;
    }


    void insert(Node n, String word){
        Node temp = n;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(temp.t[ind]==null){
                temp.t[ind] = new Node();
            }
            temp = temp.t[ind];
        }
        temp.end = true;
    }
}


// import java.util.*;

// class Node {
//     Node[] t;
//     boolean end;
//     Node() {
//         t = new Node[26];
//         end = false;
//     }
// }

// class Solution {
//     public List<String> findWords(char[][] board, String[] words) {
//         Node head = new Node();
//         Set<String> ans = new HashSet<>(); // Use Set to avoid duplicate words
//         boolean[][] visited = new boolean[board.length][board[0].length];

//         // Insert all words into the trie
//         for (String word : words) {
//             insert(head, word);
//         }

//         // Perform DFS on each cell of the board
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 dfs(i, j, head, board, "", ans, visited);
//             }
//         }

//         return new ArrayList<>(ans); // Convert the set back to a list
//     }

//     static void dfs(int i, int j, Node n, char[][] board, String temp, Set<String> ans, boolean[][] visited) {
//         if (n == null || i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return;
        
//         // Move to the child node corresponding to board[i][j]
//         n = n.t[board[i][j] - 'a'];
//         if (n == null) return;

//         temp += board[i][j];
        
//         // If it's the end of a word, add it to the answer
//         if (n.end) {
//             ans.add(temp);
//         }

//         // Mark this cell as visited
//         visited[i][j] = true;

//         // Explore all four possible directions
//         dfs(i - 1, j, n, board, temp, ans, visited); // up
//         dfs(i + 1, j, n, board, temp, ans, visited); // down
//         dfs(i, j - 1, n, board, temp, ans, visited); // left
//         dfs(i, j + 1, n, board, temp, ans, visited); // right

//         // Backtrack: unmark the cell
//         visited[i][j] = false;
//     }

//     void insert(Node n, String word) {
//         Node temp = n;
//         for (char c : word.toCharArray()) {
//             int ind = c - 'a';
//             if (temp.t[ind] == null) {
//                 temp.t[ind] = new Node();
//             }
//             temp = temp.t[ind];
//         }
//         temp.end = true;
//     }
// }
