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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = new ListNode(-1);
        temp.next = list1;


        ListNode list2End = list2;
        while(list2End.next!=null)list2End=list2End.next;

        ListNode list1B = temp;
        ListNode list1A = temp;
        int count = -1;
        while(count<=b+1){
            if(count==a-1){
                list1A=list1B;
            }
            if(count==b+1){
                break;
            }
            list1B=list1B.next;
            count++;
        }


        list1A.next = list2;
        list2End.next = list1B;

        return temp.next;
    }
}