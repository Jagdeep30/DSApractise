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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        inorder(root,ls);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ls.size()-1;i++){
            min = Math.min(min,ls.get(i+1)-ls.get(i));
        }
        return min;
    }
    static void inorder(TreeNode root, List<Integer> ls){
        if(root==null)return;
        inorder(root.left,ls);
        ls.add(root.val);
        inorder(root.right,ls);
    }
}