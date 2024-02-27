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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans-1;
    }

     int height(TreeNode root){
        if(root==null)return 0;

       int left =  height(root.left);
        int right = height(root.right);

        if(left+right+1>ans){
            ans = left+right+1;
        }

        return Math.max(left,right)+1;
    }
}