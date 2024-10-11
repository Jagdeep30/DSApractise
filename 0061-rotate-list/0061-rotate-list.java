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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0)return head;
        // reverse whole list
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head;
        int n = 0;
        while(curr!=null){
            curr = curr.next;
            n++;
        }
        k = k % n;
        if(k==n || k == 0)return head;
        curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        n = 0;
        curr = head;
        prev = null;
        next = null;
        while(n<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n++;
        }
        head.next = curr;
        ListNode nhead = prev;
        prev = null;
        next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;

        return nhead;
    }
}