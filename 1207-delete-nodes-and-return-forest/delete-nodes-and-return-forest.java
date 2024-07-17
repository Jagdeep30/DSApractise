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
    public List<TreeNode> delNodes(TreeNode root, int[] del) {
        // Map<TreeNode,Pair<TreeNode,TreeNode>> child = new HashMap<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Map<Integer,TreeNode> mapping = new HashMap<>();
        parent.put(root,null);
        dfs(root,parent,mapping);
        boolean rootDel = false;

        for(int i=0;i<del.length;i++){
            if(del[i]==root.val)rootDel=true;
            TreeNode temp = mapping.get(del[i]);
            if(temp.left!=null){
                parent.put(temp.left,null);
            }
            if(temp.right!=null){
                parent.put(temp.right,null);
            }

            TreeNode par = parent.get(temp);
            if(par != null && par.left!=null && par.left.val == temp.val){
                par.left = null;
            }else if(par!=null) par.right = null;

            parent.remove(temp);
        }
        List<TreeNode> ans = new ArrayList<>();
        for(Map.Entry<TreeNode,TreeNode> e: parent.entrySet()){
            if(rootDel && e.getKey().val==root.val)continue;
            if(e.getValue()==null){
                ans.add(e.getKey());
            }
        }
        return ans;
    }

    static void dfs(TreeNode root, Map<TreeNode,TreeNode> parent, Map<Integer,TreeNode> mapping){
        if(root==null)return;

        mapping.put(root.val,root);
        if(root.left!=null){
            parent.put(root.left,root);
        }
        if(root.right!=null){
            parent.put(root.right,root);
        }
        // child.put(root,new Pair<TreeNode,TreeNode>(root.left,root.right));

        dfs(root.left,parent,mapping);
        dfs(root.right,parent,mapping);
    }
}