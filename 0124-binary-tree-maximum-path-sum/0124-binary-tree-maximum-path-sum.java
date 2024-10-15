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
    static int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        find(root);
        return max;
    }
    static int find(TreeNode root){
        if(root==null)return Integer.MIN_VALUE;
        if(root.left==null && root.right==null){
            max = Math.max(max,root.val);
            return root.val;
        }

        int left = find(root.left);
        int right = find(root.right);

        int sum = (left!=Integer.MIN_VALUE?left:0)+(right!=Integer.MIN_VALUE?right:0)+root.val;
        max = Math.max(max,sum);
        max = Math.max(max,root.val);
        if(left!=Integer.MIN_VALUE)max = Math.max(max,root.val+left);
        if(right!=Integer.MIN_VALUE)max = Math.max(max,right+root.val);
        return Math.max(root.val,root.val + (left>right?left:right));
    }
}