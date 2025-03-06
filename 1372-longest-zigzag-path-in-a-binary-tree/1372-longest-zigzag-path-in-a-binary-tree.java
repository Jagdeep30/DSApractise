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
    int max = Integer.MIN_VALUE;
    Map<TreeNode, Pair<Integer, Integer>> mp = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        if(root==null)return 0;

        max = Math.max(max,findMax(root,true));
        max = Math.max(max,findMax(root,false));

        longestZigZag(root.left);
        longestZigZag(root.right);

        return max-1;
    }

    public int findMax(TreeNode root, boolean left){
        if(root==null)return 0;

        Pair<Integer, Integer> p = mp.getOrDefault(root, new Pair<Integer,Integer>(-1,-1));
        if(left && p.getKey()!=-1)return p.getKey();
        if(!left && p.getValue()!=-1)return p.getValue();
        
        int val = findMax(left?root.left:root.right, !left) + 1;
        if(left)mp.put(root, new Pair<Integer,Integer>(val,p.getValue()));
        else mp.put(root, new Pair<Integer,Integer>(p.getKey(),val));

        return val;
    }
}