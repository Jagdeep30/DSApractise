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
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode start = head;
        ListNode end = head;
        while(end.next!=null)end=end.next;
        ListNode nhead = mergeSort(start,end);
        
        // ListNode temp = nhead;



        return nhead;
    }

    static ListNode mergeSort(ListNode start, ListNode end){
        // if(start==null || end==null)return null;
        if(start==end)return start;

        ListNode slow = start;
        ListNode fast = start.next;
        while(fast!=end.next && fast.next!=end.next){
            slow = slow.next;
            fast = fast.next.next;
            // if(fast!=fast.next)fast=fast.next;
        }
        ListNode mid = slow;
        ListNode sec = mid.next;
        mid.next = null;
        // System.out.println("mid is -> "+mid.val);
        ListNode left = mergeSort(start,mid);
        ListNode right = mergeSort(sec,end);

        // ListNode newHead = start.val<mid.next.val?start:mid.next;

        ListNode nhead = merge(left,right);

        return nhead;
    }

    static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1!=null) temp.next = list1;
        else temp.next = list2;

        return dummyNode.next;
            





    }
}