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
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0,nums.length-1,nums);
    }

    static TreeNode solve(int s, int e, int[]nums){
        if(s>e)return null;
        int ind = (s+e)/2;
        TreeNode n = new TreeNode(nums[ind]);
        n.left = solve(s,ind-1,nums);
        n.right = solve(ind+1,e,nums);

        return n;
    }
}