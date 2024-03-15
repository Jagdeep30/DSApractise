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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;

        boolean oddInd = true;
        while(temp!=null){
            if(oddInd){
                odd.next = temp;
                odd = odd.next;
                oddInd = false;
            }
            else{
                even.next = temp;
                even = even.next;
                oddInd = true;
            }
            temp = temp.next;
        }

        odd.next = evenHead.next;
        even.next = null;
        return head;
    }
}