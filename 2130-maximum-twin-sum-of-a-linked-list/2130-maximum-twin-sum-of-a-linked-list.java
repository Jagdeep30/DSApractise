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
    public int pairSum(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null)fast = fast.next;
        }
        temp = reverse(slow);

        int max = Integer.MIN_VALUE;
        while(head!=null && temp!=null){
            max = Math.max(max, head.val+temp.val);
            head = head.next;
            temp = temp.next;
        }
        return max;
    }

    static ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode prev = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}