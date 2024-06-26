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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> sorted = new ArrayList<>();
        inorder(root,sorted);
        return buildTree(0,sorted.size()-1,sorted);
    }

    static void inorder(TreeNode root,List<TreeNode> sorted){
        if(root==null)return;

        inorder(root.left,sorted);
        sorted.add(root);
        inorder(root.right,sorted);
    }

    static TreeNode buildTree(int s, int e, List<TreeNode> arr){
        //base case
        if(e<s)return null;

        int mid = s+(e-s)/2;
        TreeNode left = buildTree(s,mid-1,arr);
        TreeNode right = buildTree(mid+1,e,arr);
        TreeNode root = arr.get(mid);
        root.left = left;
        root.right = right;
        return root;

    }
}