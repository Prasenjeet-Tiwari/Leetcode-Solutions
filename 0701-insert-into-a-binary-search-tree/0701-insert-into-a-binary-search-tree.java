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

    public TreeNode insertNode(TreeNode root, int data){

        if(root==null){
            return new TreeNode(data);
        }

        if(data < root.val){
            root.left=insertNode(root.left, data);
        }else{
            root.right=insertNode(root.right, data);
        }

        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertNode(root, val);
    }
}