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
    public int goodNodes(TreeNode root) {
        return findGood(root,Integer.MIN_VALUE);
    }

    static int findGood(TreeNode root, int max){
        if(root==null)return 0;
        if(root.left == null && root.right == null && root.val>=max)return 1;

        int left = findGood(root.left, Math.max(max,root.val));
        int right = findGood(root.right, Math.max(max,root.val));

        return left + right + (root.val>=max?1:0);
    }
}