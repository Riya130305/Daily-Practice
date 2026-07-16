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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> arr;

        if(root==nullptr) return arr;
        q.push(root);
        // while(root!=nullptr){
            
            while(!q.empty()){
                vector<int> res;
                int n=q.size();
                for(int i=0;i<n;i++){
                    TreeNode* node=q.front();
                    q.pop();
                    res.push_back(node->val);
                    if(node->left!=nullptr){
                        q.push(node->left);
                    }
                    if(node->right!=nullptr){
                        q.push(node->right);
                    }
                }
            arr.push_back(res);
        }
        return arr;
    }
};