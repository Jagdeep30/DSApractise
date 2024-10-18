/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return node;
        Node ans = new Node(node.val);
        Map<Integer,Node> p = new HashMap<>();
        p.put(node.val,ans);
        dfs(node,ans,new HashMap<Node,Boolean>(),p);
        return ans;
    }

    static void dfs(Node node, Node t, Map<Node,Boolean> mp, Map<Integer,Node> p){
        if(mp.getOrDefault(node,false))return;

        mp.put(node,true);
        List<Node> ls = node.neighbors;
        for(int i=0;i<ls.size();i++){
            Node n = p.getOrDefault(ls.get(i).val,new Node(ls.get(i).val));
            t.neighbors.add(n);
            p.put(ls.get(i).val,n);
            if(!mp.getOrDefault(ls.get(i),false))dfs(ls.get(i),n,mp,p);
        }

        return;
    }
}