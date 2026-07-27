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
    TreeNode* deleteNode(TreeNode* root, int key) {


        if(root==nullptr) return nullptr;

        else if(key < root->val){
            root->left=deleteNode(root->left,key);
            return root;
        }

        else if(key > root->val){
            root->right=deleteNode(root->right,key);
            return root;
        }

        else{
            // leaf node delete
            if(root->left==nullptr &&root->right==nullptr){
                delete root;
                return nullptr;
            } 
            //right child is null
            else if(root->right==nullptr){
                TreeNode* temp=root->left;
                delete root;
                return temp;
            }
            //left child is null
            else if(root->left==nullptr){
                TreeNode* temp=root->right;
                delete root;
                return temp;
            }
            // when both child exist
            else{
                TreeNode* parent=root;
                TreeNode* child=root->left;

                while(child->right!=nullptr){
                    parent=child;
                    child=child->right;
                }

             // If parent and root are different nodes
        if (root != parent) {
            parent->right = child->left;
            child->left = root->left;
            child->right = root->right;
            delete root;
            return child;
        } 
        // If parent and root are the same node (left child had no right child)
        else {
            child->right = root->right;
            delete root;
            return child;
        }
            }

        }
        
    }
};