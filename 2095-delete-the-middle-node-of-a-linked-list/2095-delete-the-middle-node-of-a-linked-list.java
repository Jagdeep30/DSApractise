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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)return null;
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode i = temp;
        ListNode j = temp;
        while(j!=null && j.next!=null && j.next.next!=null){
            i = i.next;
            j = j.next;
            if(j!=null)j = j.next;
        }
        i.next = i.next.next;
        return head;
    }
}