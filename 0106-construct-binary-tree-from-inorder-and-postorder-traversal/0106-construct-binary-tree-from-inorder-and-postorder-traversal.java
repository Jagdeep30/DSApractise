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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length-1;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return build(inorder,postorder,0,inorder.length-1,mp);
    }
    static TreeNode build(int[] inorder, int[] postorder, int s, int e, Map<Integer,Integer> mp){
        if(i==-1)return null;
        if(s>e)return null;

        TreeNode t = new TreeNode(postorder[i]);
        i--;
        int k = mp.get(postorder[i+1]);
        t.right = build(inorder, postorder, k+1, e, mp);
        t.left = build(inorder, postorder, s, k-1, mp);
        return t;
    }
}