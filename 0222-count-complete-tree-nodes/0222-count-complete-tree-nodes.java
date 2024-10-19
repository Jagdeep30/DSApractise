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
    public int countNodes(TreeNode root) {

        //BFS
        // if(root==null)return 0;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // int c = 0;
        // while(!q.isEmpty()){
        //     TreeNode t = q.poll();
        //     c++;
        //     if(t.left!=null)q.add(t.left);
        //     if(t.right!=null)q.add(t.right);
        // }
        // return c;

        //DFS
        if(root==null)return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}