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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return delete(root,low,high);
    }

    TreeNode delete(TreeNode node, int low, int high){
        if(node==null)return null;

        node.left = delete(node.left, low, high);
        node.right = delete(node.right, low, high);

        if(node.left==null && node.right==null && (node.val<low || node.val>high))return null;
        if(node.left==null && node.right!=null && (node.val<low || node.val>high))return node.right;
        if(node.left!=null && node.right==null && (node.val<low || node.val>high))return node.left;
        if(node.val>=low && node.val<=high)return node;

        //find smallest on right hand side
        TreeNode temp = node.right;
        while(temp.left!=null)temp = temp.left;
        node.val = temp.val;
        temp.val = -1;
        node.right = delete(node.right,low,high);
        return node;
    }
}