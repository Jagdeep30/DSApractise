/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // int min;
    static int max;
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> mp = new HashMap<>();
        // min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        solve(root,0,mp);
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<=max;i++){
            ls.add(mp.get(i));
        }
        return ls;
    }
    static void solve(TreeNode root, int h, Map<Integer,Integer> mp){
        if(root==null)return;
        h++;
        max = Math.max(max,h);
        mp.put(h,root.val);
        solve(root.left,h,mp);
        solve(root.right,h,mp);
    }
}