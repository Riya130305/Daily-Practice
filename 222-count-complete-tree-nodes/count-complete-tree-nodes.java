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
    static int count=0;
    public int countNodes(TreeNode node) {
        count=0;
        fun(node);
        return count;
    }
    public static void fun(TreeNode node)
    {
        if(node==null)
        return;
        count++;
        fun(node.left);
        fun(node.right);
        
    
    }
}