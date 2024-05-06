/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static Map<ListNode,Boolean> mp;
    public ListNode removeNodes(ListNode head) {
        mp = new HashMap<ListNode,Boolean>();
        checkDel(head);

        // System.out.println(mp);

        head = deleteNodes(head);
        return head;
    }

    static ListNode deleteNodes(ListNode head){
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode it = temp;
        while(it.next!=null){
            if(mp.getOrDefault(it.next,false)){
                it.next = it.next.next;
            }
            else it = it.next;
        }

        // System.out.println(it.val + "----it");
        if(it.next!=null)System.out.println(it.next.val + "----it next");

        return temp.next;
    }

    static int checkDel(ListNode node){
        if(node.next==null)return node.val;

        int max = checkDel(node.next);

        if(node.val>=max){
            return node.val;
        }
        else{
            mp.put(node,true);
            return max;
        }
    }
}