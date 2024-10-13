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
    static int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++)mp.put(inorder[i],i);
        return solve(preorder,inorder,0,inorder.length-1,mp);
    }
    static TreeNode solve(int[] preorder, int[] inorder, int j, int k, Map<Integer,Integer> mp){
        // System.out.println(i+" "+preorder.length);
        if(i>=preorder.length)return null;
        if(j>k)return null;
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        int l = mp.get(preorder[i-1]);
        root.left = solve(preorder,inorder,j,l-1,mp);
        root.right = solve(preorder,inorder,l+1,k,mp);
        return root;
    }
}