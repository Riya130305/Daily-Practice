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
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(root==nullptr) return false;
        int sum=0;
        return fun(root,sum,targetSum);

    }
public: 
    bool fun(TreeNode* root, int sum, int targetSum){

        if(root==nullptr) return false;
        sum+=root->val;
        if(sum==targetSum && root->left==nullptr && root->right==nullptr) return true;

        bool left=fun(root->left, sum,targetSum);
        
        bool right=fun(root->right,sum,targetSum);

        if(left || right) return true;
        return false;


    }
};