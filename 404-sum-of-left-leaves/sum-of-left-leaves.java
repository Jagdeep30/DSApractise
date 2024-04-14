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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }

        int ans = 0;
        if(root.left!=null && isLeaf(root.left)){
            ans+=root.left.val;
        }
        ans += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        return ans;
    }

    static boolean isLeaf(TreeNode node){
        if(node==null)return false;
        if(node.left==null && node.right==null)return true;
        return false;
    }
}