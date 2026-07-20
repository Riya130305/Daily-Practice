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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> arr;
        if(root==nullptr) return arr;

        queue<TreeNode*> q;
        q.push(root);
        bool flag=false;

        while(!q.empty()){
            int n=q.size();
            vector<int>res;
            for(int i=0;i<n;i++){
                TreeNode* node=q.front();
                q.pop();
                res.push_back(node->val);
                if(node->left!=nullptr) q.push(node->left);
                if(node->right!=nullptr) q.push(node->right);
            }
            if(flag==true){
            reverse(res.begin(),res.end());
            arr.push_back(res);
            }
            else{
                arr.push_back(res);
            }
            flag=!flag;
        }
        return arr;
    }
};