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
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode();
        ListNode r = new ListNode();
        ListNode temp = head;
        ListNode ltemp = l;
        ListNode rtemp = r;
        while(temp!=null){
            if(temp.val<x){
                ltemp.next = temp;
                ltemp = ltemp.next;
            }else{
                rtemp.next = temp;
                rtemp = rtemp.next;
            }
            temp = temp.next;
        }
        ltemp.next = r.next;
        rtemp.next = null;
        return l.next;
    }
}