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
class BSTIterator {
    static List<Integer> ls;
    static int i;
    static int n;
    public BSTIterator(TreeNode root) {
        ls = new ArrayList<>();
        inorder(root);
        i=-1;
        n=ls.size();
    }
    static void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        i++;
        return ls.get(i);
    }
    
    public boolean hasNext() {
        return i+1<n;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */