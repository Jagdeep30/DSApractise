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
    public int maxDepth(TreeNode root) {
        // int max = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int c = 0;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top==null){
                if(!q.isEmpty())q.add(null);
                c++;
                continue;
            }
            if(top.left!=null)q.add(top.left);
            if(top.right!=null)q.add(top.right);
            // if(q.peek()==null){
            //     q.add(null);
            // }
        }
        return c;
    }
}