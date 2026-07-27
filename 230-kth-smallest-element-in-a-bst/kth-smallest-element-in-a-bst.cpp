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
    int pos=0;
public:
    TreeNode* inOrder(TreeNode* root,int k){
        if(root==nullptr) return root;

        TreeNode* left=inOrder(root->left,k);
        if(left!=nullptr){
            return left;
        }
        pos++;
        if(pos==k){
            return root;
        }
        
       TreeNode* right=inOrder(root->right,k);
        if(right!=nullptr){
            return right;
        }
        return nullptr;
    }    
public:
    int kthSmallest(TreeNode* root, int k) {
        if(root==nullptr) return 0;
        TreeNode* node= inOrder(root,k);
        if(node==nullptr) return -1;
        return node->val;
        

    }
};

// class Solution {
// public:
//     void inOrder(TreeNode* root,vector<int> &arr){
//         if(root==nullptr) return ;

//         inOrder(root->left,arr);
//         arr.push_back(root->val);
//         inOrder(root->right,arr);
//     }    
// public:
//     int kthSmallest(TreeNode* root, int k) {
//         if(root==nullptr) return 0;
//         vector<int> arr;
//         inOrder(root,arr);

//         for(int i=0;i<arr.size();i++){
//             if(i==k-1){
//                 return arr[i];
//             }
//         }
//         return 0;

//     }
// };