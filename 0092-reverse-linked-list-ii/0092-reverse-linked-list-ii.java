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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)return head;
        ListNode temp = head;
        int c = 1;
        while(temp!=null && c<left-1){
            System.out.println("c");
            temp = temp.next;
            c++;
        }
        if(left==1)right++;
        ListNode curr = left==1?temp:temp.next;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null && c<right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
            // System.out.println(temp.val);
        if(left==1){
            head.next = curr;
        }
        else{
            temp.next.next = curr;
            temp.next = prev;
        }
        return left==1?prev:head;
    }
}