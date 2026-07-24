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
    int fun(TreeNode* root, int &count){
        if(root==nullptr) return 0;
        count++;
        int left=fun(root->left,count);
        int right=fun(root->right,count);
        return count;

    }
public:
    int countNodes(TreeNode* root) {
        if(root==nullptr) return 0;

        int count=0;
       return fun(root,count);
        //return count;
    }
};