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
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer,Integer> mp = new HashMap<>();

        // return dfs(root,mp,0);
        return bfs(root);
    }

    static boolean dfs(TreeNode root,Map<Integer,Integer> mp, int level){
        if(root==null)return true;
        if(((level & 1) == 0 && (root.val & 1) == 0) || ((level & 1) == 1 && (root.val & 1) == 1) || ((level & 1) == 0 && root.val <= mp.getOrDefault(level,0)) || ((level & 1) == 1 && root.val >= mp.getOrDefault(level,1000001)))return false;

        // if((level & 1) == 0 && root.val <= mp.getOrDefault(level,0))return false;
        // else if((level & 1) == 1 && root.val >= mp.getOrDefault(level,1000001))return false;

        mp.put(level,root.val);

        return dfs(root.left,mp,level+1) && dfs(root.right,mp,level+1);
    }


    static boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        int prev = 0;
        int level = 0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();

            if(temp==null){
                level++;
                if(level%2==0){
                    prev = 0;
                }
                else{
                    prev = 1000001;
                }
                if(!q.isEmpty())q.add(null);
                continue;
            }

            if(level%2==0){
                // System.out.println(temp.val + "level -> " + level);
                if(temp.val%2==0 || temp.val <= prev)return false;
                prev = temp.val;
            }
            else{
                // System.out.println(temp.val + "level -> " + level);
                if(temp.val%2==1 || temp.val >= prev)return false;
                prev = temp.val;
            }

            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }

        return true;
    }
}