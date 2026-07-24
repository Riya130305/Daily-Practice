class Solution {
public:

    int ans = 0;

    int subtreeSum(TreeNode* root)
    {
        if(root == nullptr)
            return 0;


        int left = subtreeSum(root->left);

        int right = subtreeSum(root->right);


        // current node ka tilt
        ans += abs(left - right);


        // parent ko current subtree ka total sum return
        return root->val + left + right;
    }


    int findTilt(TreeNode* root) {

        ans = 0;   // reset answer

        subtreeSum(root);

        return ans;
    }
};