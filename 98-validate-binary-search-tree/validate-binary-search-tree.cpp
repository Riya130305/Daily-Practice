class Solution {

    TreeNode* prev = nullptr;

public:

    bool inOrder(TreeNode* root){

        if(root == nullptr)
            return true;


        // left
        if(!inOrder(root->left))
            return false;


        // current
        if(prev != nullptr && root->val <= prev->val)
            return false;


        prev = root;


        // right
        if(!inOrder(root->right))
            return false;


        return true;
    }


    bool isValidBST(TreeNode* root){

        return inOrder(root);

    }
};