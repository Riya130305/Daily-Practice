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
    static int ans1=0; 
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null))
        return 0;
        ans1=0;
        //int sum=0;
        fun(root,false);
        return ans1;
    }
    public static void fun(TreeNode root,boolean flag)
    {
        
        if(root==null)
        return ;

        if(root.left==null && root.right==null && flag==true)
        {
            ans1+=root.val;
        }
      
        fun(root.left,true);
        fun(root.right,false);
   
    }
}