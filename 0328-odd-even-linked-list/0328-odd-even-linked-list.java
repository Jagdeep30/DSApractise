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
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oddH = odd;
        ListNode evenH = even;
        int i=1;
        ListNode temp = head;
        while(temp!=null){
            if(i%2==0){
                evenH.next = temp;
                evenH = evenH.next;
            }else{
                oddH.next = temp;
                oddH = oddH.next;
            }
            temp = temp.next;
            i++;
        }
        oddH.next = even.next;
        evenH.next = null;
        return odd.next;
    }
}