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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(Math.abs(heigth(root.left)-heigth(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int heigth(TreeNode root)
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        int l=heigth(root.left);
        // System.out.println("left "+l);
        int r=heigth(root.right);
        // System.out.println("right "+r);
        
        return Math.max(l,r)+1;
        
    }
}