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
    static int max;
    public List<Double> averageOfLevels(TreeNode root) {
        max = Integer.MIN_VALUE;
        Map<Integer,Pair<Long,Integer>> mp = new HashMap<>();
        find(root,0,mp);
        List<Double> ans = new ArrayList<>();
        for(int i=1;i<=max;i++){
            Pair<Long,Integer> p = mp.get(i);
            ans.add((double)p.getKey()/p.getValue());
        }
        return ans;
    }
    static void find(TreeNode root, int h, Map<Integer,Pair<Long,Integer>> mp){
        if(root==null)return;
        h++;
        max = Math.max(max,h);
        Pair<Long,Integer> sum = mp.getOrDefault(h,new Pair<Long,Integer>((long)0,0));
        sum = new Pair<Long,Integer>(sum.getKey()+root.val,sum.getValue()+1);
        mp.put(h,sum);
        find(root.left,h,mp);
        find(root.right,h,mp);
    }
}