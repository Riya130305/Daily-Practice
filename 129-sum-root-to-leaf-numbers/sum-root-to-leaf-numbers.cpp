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
    void fun(TreeNode* root, string  pSum, int &sum){
        if(root==nullptr) return ;

        pSum+=to_string(root->val);
        
        if(root->left==nullptr && root->right==nullptr){
            sum=sum+stoi(pSum);
            return;
        }
        fun(root->left,pSum,sum);
        fun(root->right,pSum,sum);
        
    }

public:
    int sumNumbers(TreeNode* root) {
        if(root==nullptr) return 0;
        int sum=0;

        fun(root,"",sum);
        return sum;

    }
};