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
    public int rob(TreeNode root) {
        int[] res = solve(root, new HashMap<TreeNode, ArrayList<Integer>>());
        return Math.max(res[0], res[1]);
    }

    static int[] solve(TreeNode node, Map<TreeNode, ArrayList<Integer>> dp){
        //base case
        if(node==null)return new int[2];
        if(node.left==null && node.right==null)return new int[]{node.val, 0};

        ArrayList<Integer> p = dp.getOrDefault(node,null);
        if(p!=null && p.size()==2){
            return new int[]{p.get(0),p.get(1)};
        }
        else p = new ArrayList<Integer>();

        int max = Integer.MIN_VALUE;

        //left
        int[] left = solve(node.left, dp);
        //right
        int[] right = solve(node.right, dp);

        //current included
        int inc = node.val + left[1] + right[1];
        //current excluded
        int exc = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        p.add(inc);
        p.add(exc);
        dp.put(node, p);
        return new int[]{inc, exc};
    }
}