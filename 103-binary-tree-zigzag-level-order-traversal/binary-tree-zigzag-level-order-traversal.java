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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Queue<TreeNode> q = new LinkedList<>();
        arr.add(List.of(root.val));
        q.add(root);
        int lvl=1;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    ans.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    ans.add(node.right.val);
                }
            }
            if (ans.size() != 0 && lvl%2==1){
                Collections.reverse(ans);
                arr.add(ans);
            }
            else if(ans.size() != 0){
                arr.add(ans);
            }
            lvl++;
        }
       return arr;
    }
}