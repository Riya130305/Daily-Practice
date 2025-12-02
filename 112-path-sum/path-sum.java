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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null )
        return false;

        int sum=0;
        boolean ans = fun(root,targetSum,sum);
        return ans;
    }
    public static boolean fun(TreeNode root,int targetSum,int sum)
    {
         if (root == null) return false;
         sum+=root.val;
        if(root.left==null && root.right==null)
        return sum==targetSum;

        
        
        boolean ans1=fun(root.left,targetSum,sum);
        boolean ans2=fun(root.right,targetSum,sum);

        if(ans1 || ans2)
        return true;
         
        return false;

    }
   
}