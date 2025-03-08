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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ls = new ArrayList<>();        
        List<Integer> lss = new ArrayList<>();        
        leafSeq(root1,ls);
        leafSeq(root2,lss);

        // System.out.println(ls);
        // System.out.println(lss);
        return ls.equals(lss);
    }

    static void leafSeq(TreeNode root, List<Integer> ls){
        if(root==null)return;
        if(root.left == null && root.right==null){
            ls.add(root.val);
            return;
        }

        leafSeq(root.left,ls);
        leafSeq(root.right,ls);

        return;
    }
}