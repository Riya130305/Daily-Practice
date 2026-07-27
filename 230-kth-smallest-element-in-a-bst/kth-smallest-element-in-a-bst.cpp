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
    void inOrder(TreeNode* root,vector<int> &arr){
        if(root==nullptr) return ;

        inOrder(root->left,arr);
        arr.push_back(root->val);
        inOrder(root->right,arr);
    }    
public:
    int kthSmallest(TreeNode* root, int k) {
        if(root==nullptr) return 0;
        vector<int> arr;
        inOrder(root,arr);

        for(int i=0;i<arr.size();i++){
            if(i==k-1){
                return arr[i];
            }
        }
        return 0;

    }
};