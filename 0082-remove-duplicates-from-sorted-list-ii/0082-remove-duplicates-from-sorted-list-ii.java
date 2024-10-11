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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nhead = new ListNode(-1,head);
        ListNode temp = nhead;
        while(temp!=null && temp.next!=null){
            ListNode t = temp.next;
            int c = 0;
            while(t!=null && t.val==temp.next.val){
                t = t.next;
                c++;
            }
            if(c>1){
                temp.next = t;
            }
            else temp = temp.next;
        }
        return nhead.next;
    }
}