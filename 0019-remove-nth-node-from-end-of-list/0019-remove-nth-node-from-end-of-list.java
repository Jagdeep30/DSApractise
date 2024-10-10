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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
       ListNode fast = nHead;
       ListNode slow = nHead;
       while(fast != null && n!=-1){
        fast = fast.next;
        n--;
       }
    //    if(fast==null)return head.next;
       while(fast!=null){
        fast = fast.next;
        slow = slow.next;
       }
       slow.next = slow.next.next;
       return nHead.next;
    }
}