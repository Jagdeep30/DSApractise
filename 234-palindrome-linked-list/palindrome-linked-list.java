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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && slow!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null)fast=fast.next;
        }

        ListNode head2 = reverse(slow);

        while(head!=null && head2!=null){
            if(head.val!=head2.val)return false;
            head=head.next;
            head2=head2.next;
        }

        return true;
    }

    static ListNode reverse(ListNode node){
        if(node==null || node.next==null)return node;

        ListNode nHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return nHead;
    }
}