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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return dfs(root,0,targetSum);
    }
    static boolean dfs(TreeNode root, int sum, int target){
        if(root==null)return false;
        if(root.left==null && root.right==null){
            if(sum+root.val==target)return true;
            return false;
        }

        sum+=root.val;
        boolean left = dfs(root.left,sum,target);
        if(left)return true;
        boolean right = dfs(root.right,sum,target);
        if(right)return true;
        return false;

    }
}