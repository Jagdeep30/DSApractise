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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean rev = false;
        q.add(root);
        q.add(null);
        List<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null){
                if(temp.size()!=0){
                    if(rev)Collections.reverse(temp);
                    rev = !rev;
                    ls.add(temp);
                    temp = new ArrayList<>();
                }
                continue;
            }
            temp.add(curr.val);
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
            if(q.peek()==null)q.add(null);
        }
        return ls;
    }
}