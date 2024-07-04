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
    public ListNode mergeNodes(ListNode head) {
        ListNode ansHead = new ListNode(-1);
        ListNode ansTemp = ansHead;
        ListNode temp = head;

        while(temp!=null){
            if(temp.val==0){
                temp = temp.next;
                int sum = 0;
                while(temp!=null && temp.val!=0){
                    sum+=temp.val;
                    temp = temp.next;
                }
                if(temp!=null){
                    ansTemp.next = new ListNode(sum);
                    ansTemp = ansTemp.next;
                }
            }
        }

        return ansHead.next;
    }
}