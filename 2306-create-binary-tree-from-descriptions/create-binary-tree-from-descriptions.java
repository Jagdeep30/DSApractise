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
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer,TreeNode> mp = new HashMap<>();
        Map<Integer,Boolean> isRoot = new HashMap<>();
        int n = desc.length;
        for(int i=0;i<n;i++){
            int parent = desc[i][0];
            int child = desc[i][1];
            int isLeft = desc[i][2];

            TreeNode parentN = mp.getOrDefault(parent,null);
            TreeNode childN = mp.getOrDefault(child,null);

            // if(childN==null){
            //     // System.out.println("Index is " + i + " child " + child + "  not exists");
            // }else System.out.println("Index is " + i + " child " + child + " exists");

            if(parentN==null){
                parentN = new TreeNode(parent);
                mp.put(parent,parentN);
            }
            if(childN==null){
                childN = new TreeNode(child);
                mp.put(child,childN);
                // System.out.println("child "+ child +" set to " + isRoot.get(child));
            }
            isRoot.put(parent,isRoot.getOrDefault(parent,true));
            isRoot.put(child,false);

            if(isLeft==1)parentN.left = childN;
            else parentN.right = childN;
        }
        // System.out.println(isRoot);
        // System.out.println(mp);
        TreeNode root = null;
        for(Map.Entry<Integer,Boolean> e: isRoot.entrySet()){
            if(e.getValue()){
                root = mp.get(e.getKey());
                break;
            }
        }

        return root;
    }
}