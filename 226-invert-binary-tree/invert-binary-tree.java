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
        
        // ---------Approch 1 Level order travesal-----
        // Queue<TreeNode> q= new LinkedList<>();
        // //TreeNode temp;
        // if(root==null)
        // return null;
        // q.add(root);
        // while(!q.isEmpty())
        // {
        //     TreeNode n=q.poll();
        //    //Swapping the node
        //    System.out.println(n.left);
        //    //if(left and right both are null means it is reversing null to null only )
        //    TreeNode temp=n.left;
        //    n.left=n.right;
        //    n.right=temp;

        //    if(n.left!=null)
        //    q.add(n.left);
        //    if(n.right!=null)
        //    q.add(n.right);
        // }
        // return root;


        //------Second Approch (RECURSION)-------

          if (root == null) return null;

        // swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}