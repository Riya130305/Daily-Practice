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
    int fun(TreeNode* root, int &sum,bool leftNode){
        if(root==nullptr) return 0;


        if(root->left==nullptr && root->right==nullptr){
            if(leftNode){
            sum+=root->val;
            return sum;
            }
        }
        fun(root->left,sum,true);
        fun(root->right,sum,false);
        return sum;
    }

public:
    int sumOfLeftLeaves(TreeNode* root) {
        if(root==nullptr) return 0;

        int sum=0;
        return fun(root,sum,false);
    }
};