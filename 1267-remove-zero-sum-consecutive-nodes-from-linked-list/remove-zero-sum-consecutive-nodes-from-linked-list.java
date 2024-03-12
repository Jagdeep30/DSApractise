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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode i = temp;
        ListNode j = head;
        int sum = 0;
        while(i!=null && i.next!=null){
                // System.out.println(i.val);

            j=i.next;
            while(j!=null){
                sum+=j.val;
                if(sum==0){
                    // System.out.print(j.val+" ");
                    i.next = j.next;
                    j = i.next;
                    sum=0;
                }
                else{
                    j = j.next;
                }
            }
            // System.out.println();
            i=i.next;
            sum=0;
        }

        return temp.next;
    }
}