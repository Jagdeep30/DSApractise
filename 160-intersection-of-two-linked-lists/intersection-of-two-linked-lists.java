/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;

        ListNode temp = headA;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        temp = headB;
        while(temp!=null){
            m++;
            temp = temp.next;
        }

        temp = headA;
        ListNode tempa = headB;

        if(n>m){
            while(n--!=m){
                temp = temp.next;
            }
        }
        else{
            while(n!=m--){
                tempa = tempa.next;
            }
        }

        while(temp!=null && tempa!=null){
            if(temp==tempa)return temp;
            temp = temp.next;
            tempa = tempa.next;
        }

        return null;
    }
}