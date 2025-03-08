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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root==null)return ls;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            if(front==null){
                if(q.size()!=0)q.add(null);
                continue;
            }
            if(front.left!=null)q.add(front.left);
            if(front.right!=null)q.add(front.right);

            if(q.peek()==null)ls.add(front.val);
        }
        return ls;
    }
}