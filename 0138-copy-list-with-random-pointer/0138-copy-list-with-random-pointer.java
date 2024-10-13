/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node nhead = new Node(-1);
        Node t = head;
        Map<Node,Node> mp = new HashMap<>();
        while(t!=null){
            Node temp = new Node(t.val);
            mp.put(t,temp);
            t = t.next;
        }
        t = head;
        while(t!=null){
            Node temp = mp.get(t);
            temp.next = mp.get(t.next);
            temp.random = mp.get(t.random);
            t = t.next;
        }
        return mp.get(head);
    }
}