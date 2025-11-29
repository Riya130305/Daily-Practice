class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        return fun(root);
    }

    public int fun(TreeNode root) {

        if (root == null) 
            return Integer.MAX_VALUE;

        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = fun(root.left);
        int rightDepth = fun(root.right);

        return 1 + Math.min(leftDepth, rightDepth);
    }
}
