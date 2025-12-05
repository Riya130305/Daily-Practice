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
    public TreeNode invertTree(TreeNode root) {
        // Base Case
        Queue<TreeNode> q= new LinkedList<>();
        //TreeNode temp;
        if(root==null)
        return null;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode n=q.poll();
           //Swapping the node
           TreeNode temp=n.left;
           n.left=n.right;
           n.right=temp;

           if(n.left!=null)
           q.add(n.left);
           if(n.right!=null)
           q.add(n.right);
        }
        return root;
    }
}