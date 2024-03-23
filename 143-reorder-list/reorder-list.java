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
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head2 = reverse(mid);

        ListNode next = null;
        ListNode next2 = null;
        while(head!=null && head2!=null){
            next = head.next;
            next2 = head2.next;
            head.next = head2;
            head2.next = next;
            head = next;
            if(head==null && next2!=null){
                head2.next = next2;
                break;
            }
            head2 = next2;
        }

        // head2.next = next2;
    }

    static ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next = null;

        return slow;
    }

    static ListNode reverse(ListNode node){
        if(node==null || node.next==null)return node;

        ListNode nH = reverse(node.next);

        node.next.next = node;
        node.next = null;

        return nH;
    }
}