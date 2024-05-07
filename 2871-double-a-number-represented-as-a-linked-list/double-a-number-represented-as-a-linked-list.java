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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        head = doubleNum(head);
        head = reverse(head);
        return head;
    }

    static ListNode doubleNum(ListNode head){
        ListNode temp = head;
        ListNode prev = head;
        int carry = 0;

        while(temp!=null){
            int val = temp.val*2+carry;
            temp.val = val%10;
            carry = val/10;

            prev = temp;
            temp = temp.next;
        }

        if(carry!=0){
            while(carry!=0){
                int val = carry%10;
                carry/=10;
                prev.next = new ListNode(val);
                prev = prev.next;
            }
        }

        return head;
    }

    static ListNode reverse(ListNode head){
        if(head == null || head.next==null)return head;

        ListNode temp = head;
        ListNode next = null;
        ListNode prev = null;

        while(temp!=null){
            next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
        }

        return prev;
    }
}