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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        if(root.left==null && root.right==null)return root;
        if(root.left==null && root.right!=null){
            root.left = root.right;
            root.right = null;
            // return root;
        }
        else if(root.right==null && root.left!=null){
            root.right = root.left;
            root.left = null;
            // return root;
        }
        else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}