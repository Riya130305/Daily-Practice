class Solution {
public:

    int ans = INT_MIN;

    int solve(TreeNode* root)
    {
        if(root == nullptr)
            return 0;


        // child se contribution lo
        int left = solve(root->left);
        int right = solve(root->right);


        // negative contribution ko ignore karo
        left = max(0, left);
        right = max(0, right);


        // current node ke through banne wala path
        int currentPath = root->val + left + right;


        // overall answer update
        ans = max(ans, currentPath);


        // parent ko sirf ek side ka contribution de sakte hain
        return root->val + max(left, right);
    }


    int maxPathSum(TreeNode* root) {

        solve(root);

        return ans;
    }
};