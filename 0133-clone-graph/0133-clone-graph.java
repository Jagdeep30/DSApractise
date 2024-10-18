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
        Map<Node,Node> pair = new HashMap<>();
        dfsO(new HashMap<Node,Boolean>(),node,pair);
        dfsT(new HashMap<Node,Boolean>(),node,pair);
        return pair.get(node);
    }

    static void dfsT(Map<Node,Boolean> mp, Node node, Map<Node,Node> pair){
        if(mp.getOrDefault(node,false))return;

        Node t = pair.get(node);
        mp.put(node,true);
        List<Node> arr = node.neighbors;
        for(int i=0;i<arr.size();i++){
            t.neighbors.add(pair.get(node.neighbors.get(i)));
        }

        for(int i=0;i<arr.size();i++){
            if(!mp.getOrDefault(arr.get(i),false))dfsT(mp,arr.get(i),pair);
        }
        return;
    }

    static void dfsO(Map<Node,Boolean> mp, Node node, Map<Node,Node> pair){
        if(mp.getOrDefault(node,false))return;

        Node t = new Node(node.val);
        pair.put(node,t);
        mp.put(node,true);
        List<Node> arr = node.neighbors;
        for(int i=0;i<arr.size();i++){
            if(!mp.getOrDefault(arr.get(i),false))dfsO(mp,arr.get(i),pair);
        }

        return;
    }
}