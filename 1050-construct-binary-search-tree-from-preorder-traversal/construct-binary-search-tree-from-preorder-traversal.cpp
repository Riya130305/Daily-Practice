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
    TreeNode* BST(vector<int> &arr,int min, int max,int &idx){

        if(idx>=arr.size() || arr[idx] < min || arr[idx] > max){
            return nullptr;
        }
        TreeNode* node=new TreeNode(arr[idx++]);
        node->left= BST(arr,min,node->val,idx);
        node->right= BST(arr,node->val,max,idx);
        return node;
        
    }    
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int min=INT_MIN;
        int max=INT_MAX;
        int idx=0;
        return BST(preorder,min,max,idx);
    }
};