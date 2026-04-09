/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diaMax=0;
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int l= maxDepth(root.left);
        int r=maxDepth(root.right);
         diaMax=Math.max(diaMax,l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diaMax;
    }
}