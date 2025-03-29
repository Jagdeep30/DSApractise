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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;

        if(root.val==key){
            if(root.left==null && root.right==null)return null;
            if(root.left!=null && root.right==null)return root.left;
            if(root.left==null && root.right!=null)return root.right;

            TreeNode temp = root.right;
            // System.out.println(temp);
            while(temp!=null && temp.left!=null)temp = temp.left;

            root.val = temp.val;
            // temp.left = root.left;
            // root.left = null;

            root.right = deleteNode(root.right, root.val);
        }

        else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }
        else root.left = deleteNode(root.left, key);

        return root;
    }
}