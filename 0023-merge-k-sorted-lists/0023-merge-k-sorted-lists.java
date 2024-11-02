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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return solve(0,lists.length-1,lists);
    }

    static ListNode solve(int s, int e, ListNode[] lists){
        if(s==e)return lists[s];

        int mid = s + (e-s)/2;

        ListNode l = solve(s,mid,lists);
        ListNode r = solve(mid+1,e,lists);

        return merge(l,r);
    }

    static ListNode merge(ListNode l, ListNode r){
        if(l==null && r==null)return null;
        else if(l==null && r!=null)return r;
        else if(l!=null && r==null)return l;
        ListNode nh = new ListNode();
        ListNode temp = nh;

        while(l!=null && r!=null){
            if(l.val<r.val){
                temp.next = l;
                l = l.next;
                temp = temp.next;
            }else{
                temp.next = r;
                r = r.next;
                temp = temp.next;
            }
        }

        if(l!=null){
            temp.next = l;
        }
        else if(r!=null){
            temp.next = r;
        }

        return nh.next;
    }
}