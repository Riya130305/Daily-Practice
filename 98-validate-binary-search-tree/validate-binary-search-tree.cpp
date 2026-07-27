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
    bool BST(TreeNode* root, long long &prev){
        if(root==nullptr) return true;

        bool left=BST(root->left,prev);
        if(left==0) return false;

        if(root->val<=prev) return false;

        prev=root->val;
        return BST(root->right,prev);

    }    
public:
    bool isValidBST(TreeNode* root) {
       long long prev = LLONG_MIN;
        return BST(root,prev);
    }
};


// class Solution {
// public:
//     void inOrder(TreeNode* root, vector<int> &arr){
//         if(root==nullptr) return;

//         inOrder(root->left,arr);
//         arr.push_back(root->val);
//         inOrder(root->right,arr);
        
//     }    
// public:
//     bool isValidBST(TreeNode* root) {
//         if(root==nullptr) return true;
//         vector<int> arr;
//         inOrder(root,arr);

//         for(int i=1;i<arr.size();i++){
//             if(arr[i-1]>=arr[i]){
//                 return false;
//             }
//         }
//         return true;
//     }
// };