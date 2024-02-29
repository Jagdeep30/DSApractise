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
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer,Integer> mp = new HashMap<>();

        return dfs(root,mp,0);
    }

    static boolean dfs(TreeNode root,Map<Integer,Integer> mp, int level){
        if(root==null)return true;
        if(((level & 1) == 0 && (root.val & 1) == 0) || ((level & 1) == 1 && (root.val & 1) == 1) || ((level & 1) == 0 && root.val <= mp.getOrDefault(level,0)) || ((level & 1) == 1 && root.val >= mp.getOrDefault(level,1000001)))return false;

        // if((level & 1) == 0 && root.val <= mp.getOrDefault(level,0))return false;
        // else if((level & 1) == 1 && root.val >= mp.getOrDefault(level,1000001))return false;

        mp.put(level,root.val);

        return dfs(root.left,mp,level+1) && dfs(root.right,mp,level+1);
    }
}