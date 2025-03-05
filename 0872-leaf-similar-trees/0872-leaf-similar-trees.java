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
        List<Integer> a1 = new ArrayList<>();
        inorder(root1,a1);
        List<Integer> a2 = new ArrayList<>();
        inorder(root2,a2);
        if(a1.size()!=a2.size())return false;
        for(int i=0;i<a1.size();i++){
            if(a1.get(i)!=a2.get(i))return false;
        }
        return true;
    }

    static void inorder(TreeNode node, List<Integer> arr){
        if(node==null)return;

        inorder(node.left,arr);
        if(node.left==null && node.right==null)arr.add(node.val);
        inorder(node.right,arr);
    }
}