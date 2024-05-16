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
    public boolean evaluateTree(TreeNode root) {
        int ans = solve(root);
        return ans==1?true:false;
    }

    static int solve(TreeNode root){
        if(root.left==null && root.right==null){
            return root.val;
        }

        int val1 = solve(root.left);
        int val2 = solve(root.right);

        if(root.val == 2){
            return val1 | val2;
        }
        else return val1 & val2;
    }
}