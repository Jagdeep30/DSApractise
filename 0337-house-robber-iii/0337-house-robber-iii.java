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
    public int rob(TreeNode root) {
        return solve(root, false);
    }

    static int solve(TreeNode node, boolean prev){
        //base case
        if(node==null)return 0;
        if(node.left==null && node.right==null && prev)return 0;
        if(node.left==null && node.right==null && !prev)return node.val;

        int max = Integer.MIN_VALUE;
        //include this node
        //include only if the parent was not included using variable prev
        if(!prev){
            max = Math.max(max, solve(node.left, true) + solve(node.right, true) + node.val);
        }

        //don't include this node
        max = Math.max(max, solve(node.left, false) + solve(node.right, false));

        return max;
    }
}