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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root==null)
        return arr;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> lev= new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                lev.add(n.val);
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
            }
            arr.add(lev);
        }
        return arr;
    }
}