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
    vector<string> binaryTreePaths(TreeNode* root) {
        
        vector<string> arr;
        // string

        if(root==nullptr) return arr;
       
        fun(root,arr,"");
       
        return arr;
    }
    public:
        void fun(TreeNode* root, vector<string> &arr,string path){
            if(root==nullptr) return ;
           
            
            if(path.empty()){
                path = to_string(root->val);
            }
            else{
                path += "->" + to_string(root->val);
            }

             if(root->left==nullptr && root->right==nullptr){
                  arr.push_back(path);
            return;
            }

            fun(root->left,arr,path);
            fun(root->right,arr,path);
        }
};