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
    public ListNode sortList(ListNode head) {
        int i=0;
        Map<Integer,ListNode> mp = new HashMap();
        ListNode temp = head;
        while(temp!=null){
            mp.put(i,temp);
            i++;
            temp = temp.next;
        }
        // System.out.println(mp);

        return mergeSort(mp,0,i-1);
    }

    static ListNode mergeSort(Map<Integer,ListNode> mp, int s, int e){
        if(s>=e){
            ListNode t = mp.getOrDefault(s,null);
            if(t!=null){
                t.next = null;
                // System.out.println(t.val);
            }
            return t;
        }

        int mid = s + (e-s)/2;

        ListNode t1 = mergeSort(mp,s,mid);
        ListNode t2 = mergeSort(mp,mid+1,e);

        return merge(t1,t2);
    }

    static ListNode merge(ListNode t1, ListNode t2){
        ListNode nHead = new ListNode();
        ListNode nw = nHead;

        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                nw.next = t1;
                t1 = t1.next;
            }else{
                nw.next = t2;
                t2 = t2.next;
            }
            nw = nw.next;
        }

        // while(t1!=null){
        //     nw.next = t1;
        //     t1 = t1.next;
        //     nw = nw.next;
        // }
        // while(t2!=null){
        //     nw.next = t2;
        //     t2 = t2.next;
        //     nw = nw.next;
        // }

        if(t1!=null)nw.next = t1;
        else nw.next = t2;

        return nHead.next;
    }
}