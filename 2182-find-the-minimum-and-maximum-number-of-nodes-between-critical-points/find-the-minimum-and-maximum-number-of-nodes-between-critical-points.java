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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(head==null || head.next==null || head.next.next==null){
            return ans;
        }
        List<Integer> dist = new ArrayList<>();
        ListNode prev = head;
        ListNode temp = head.next;
        int ind = 1;

        while(temp.next!=null){
            if((temp.val>prev.val && temp.val>temp.next.val) || (temp.val<prev.val && temp.val<temp.next.val)){
                dist.add(ind);
            }

            ind++;
            prev = temp;
            temp = temp.next;
        }
        if(dist.size()<=1)return ans;
        Collections.sort(dist);
        ans[1] = dist.get(dist.size()-1) - dist.get(0);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<dist.size()-1;i++){
            min = Math.min(min,dist.get(i+1) - dist.get(i));
        }

        ans[0] = min;
        return ans;
    }
}