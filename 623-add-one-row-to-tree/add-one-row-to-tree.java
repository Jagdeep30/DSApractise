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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
           TreeNode newRoot = new TreeNode(val);
           newRoot.left = root;
           return newRoot;
        }
        dfs(root,val,1,depth);
        return root;
    }

    static void dfs(TreeNode root, int val, int depth, int reqD){
        if(root==null)return;

        if(depth==reqD-1){
            TreeNode leftN = new TreeNode(val);
            TreeNode rightN = new TreeNode(val);

            leftN.left = root.left;
            rightN.right = root.right;

            root.left = leftN;
            root.right = rightN;

            return;
        }

        dfs(root.left,val,depth+1,reqD);
        dfs(root.right,val,depth+1,reqD);

    }
}