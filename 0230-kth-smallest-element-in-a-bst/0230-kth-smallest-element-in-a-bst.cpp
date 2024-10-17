/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // vector<int> v;
    void inorder(TreeNode* root,int k){
        if(root==NULL)return;

        inorder(root->left,k);
        // v.push_back(root->val);
        
        // printf("size of vector = %d\n",v.size());
        inorder(root->right,k);
        // return v;       
    }
    int kthSmallest(TreeNode* root, int k) {
        // vector<int> v;
        inorder(root,k);
        // for(int i=0;i<v.size();i++){
            // printf("%d",v[1]);
        // }
        // for(int i=0;i<v.size();i++){
        //     k--;
        //     if(k==0)return v[i];
        // }
        return v[k-1];
    }

};