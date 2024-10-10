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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode t = nHead;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        temp = head;
        while(n>=k){
            ListNode[] p = reverse(temp,k);
            t.next = p[0];
            t = p[1];
            temp = p[2];
            n-=k;
        }
        if(n!=0){
            t.next = temp;
        }
        return nHead.next;
    }

    static ListNode[] reverse(ListNode temp, int k){
        ListNode curr = temp;
        ListNode next = null;
        ListNode prev = null;
        while(k!=0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return new ListNode[]{prev,temp,curr};
    }
}