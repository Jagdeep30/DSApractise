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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode it = ans;
        int carry = 0;
        int sum = 0;
        while(l1!=null && l2!=null){
            sum = l1.val+l2.val+carry;
            ListNode temp = new ListNode(sum%10);
            it.next = temp;
            carry = sum/10;
            it = it.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            sum = l1.val+carry;
            ListNode temp = new ListNode(sum%10);
            it.next = temp;
            carry = sum/10;
            it = it.next;
            l1 = l1.next;
        }
        while(l2!=null){
            sum = l2.val+carry;
            ListNode temp = new ListNode(sum%10);
            it.next = temp;
            carry = sum/10;
            it = it.next;
            l2 = l2.next;
        }
        if(carry!=0){
            ListNode temp = new ListNode(carry);
            it.next = temp;
        }
        return ans.next;
    }
}