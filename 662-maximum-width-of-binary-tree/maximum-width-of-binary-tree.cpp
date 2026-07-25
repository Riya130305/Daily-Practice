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
    typedef unsigned long long ll;
    int widthOfBinaryTree(TreeNode* root) {
        queue<pair<TreeNode*,ll>> q;
        //vector<vector<TreeNode*>>  arr;
        if(root==nullptr) return 0;
        ll max1=0;
        q.push({root,0});

        while(!q.empty()){

          //  vector<TreeNode*> res;
            int n=q.size();
            ll idx1=q.front().second;
            ll idx2=q.back().second;
            max1=max(max1,idx2-idx1+1);

            for(int i=0;i<n;i++){
                TreeNode* node=q.front().first;
                ll idx=q.front().second;
                q.pop();
                //res.push_back(node->val);
                if(node->left!=nullptr)
                    q.push({node->left,2*idx+1});
                if(node->right!=nullptr)
                    q.push({node->right,2*idx+2});
            }
            //arr.push_back(res);
        } 
        return max1;
    }
};