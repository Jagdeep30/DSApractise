/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode fast = head;
        ListNode slow = head;

        // while(fast!=null && fast.next!=null){
        //     slow = slow.next;
        //     fast = fast.next;
        //     if(fast!=null){
        //         fast = fast.next;
        //     }
        //     else return false;

        //     if(fast == slow)return true;
        // }


        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)return true;
        }
        return false;
    }
}