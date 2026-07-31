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
    vector<int> rightSideView(TreeNode* root) {
         vector<int> ans;
        if(root==nullptr) return ans;
        vector<vector<int>> arr;
        // vector<int> arr;
        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int n=q.size();
            vector<int> res;
            for(int i=0;i<n;i++){
                TreeNode* node= q.front();
                if(node==nullptr) continue;
                q.pop();
                res.push_back(node->val);
                if(node->left!=nullptr)
                    q.push(node->left);

                if(node->right!=nullptr)
                    q.push(node->right);
            }
            arr.push_back(res);
        }

       
        for(int i=0;i<arr.size();i++){
            if(!arr[i].empty()){
                ans.push_back(arr[i].back());
            }
        }
        return ans;
    }
};