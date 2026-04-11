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
     public List<String> binaryTreePaths(TreeNode root) {
       List<String> arr= new ArrayList<>();
       if(root==null) return arr;
       String st = String.valueOf(root.val);
       path(root,st,arr);
       return arr;
    }
    public static void path(TreeNode root, String st, List<String> arr){
        if(root.left==null && root.right==null){
            arr.add(st);
            return;
        }
        //st+=String.valueOf(root.val);
        if(root.left!=null){
            path(root.left,st+"->"+String.valueOf(root.left.val),arr);
        }
        if(root.right!=null){
            path(root.right,st+"->"+String.valueOf(root.right.val),arr);
        }
    }
}