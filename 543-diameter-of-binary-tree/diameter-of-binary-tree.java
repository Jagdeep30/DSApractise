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
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root == null || (root.left==null && root.right==null))return 0;
        this.max = Math.max(this.max,solve(root));
        solve(root);
        return this.max;
    }

    int solve(TreeNode node){
        if(node==null)return -1;
        if(node.left==null && node.right==null)return 0;

        int left = solve(node.left);
        int right = solve(node.right);
        
        this.max = Math.max(this.max,left+right+2);
        return Math.max(left,right)+1;
    }
}