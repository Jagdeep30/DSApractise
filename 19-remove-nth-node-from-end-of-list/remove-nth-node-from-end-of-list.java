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
        ListNode helper = new ListNode();
        helper.next = head;
        ListNode temp = helper;
        ListNode temp2 = head;
        while(n!=0){
            temp2 = temp2.next;
            n--;
        }

        while(temp2!=null){
            temp2 = temp2.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return helper.next;
    }
}