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
    public int sumNumbers(TreeNode root) {
        return calc(root,0);
    }
    static int calc(TreeNode root, int num){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
            num = (num * 10) + root.val;
            return num;
        }
        int left = 0;
        int right = 0;
        num = (num * 10) + root.val;
        if(root.left!=null)left = calc(root.left, num);
        if(root.right!=null)right = calc(root.right,num);
        return left+right;
    }
}