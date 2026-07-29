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
    TreeNode* prv=nullptr;
    TreeNode* first=nullptr;
    TreeNode* second=nullptr;

    void inOrder(TreeNode* root){
        if(root==nullptr) return ;

        inOrder(root->left);

        if(prv!=nullptr && prv->val > root->val ){
            if(first==nullptr){
                first=prv;
            }
            second=root;
        }

        prv=root;
        inOrder(root->right);
    }    

public:
    void recoverTree(TreeNode* root) {
        if(root==nullptr) return ;
        
        inOrder(root);

        // swap logic
        int temp= first->val;
        first->val=second->val;
        second->val=temp;
    }
};