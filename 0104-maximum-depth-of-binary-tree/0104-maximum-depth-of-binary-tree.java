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

     public int maximum(TreeNode root, int length){
    if(root==null){
        return length;
    }
    int left=maximum(root.left, length+1);
    int right=maximum(root.right,length+1);
    return Math.max(left,right);
    }

    public int maxDepth(TreeNode root) {
        int ans= maximum(root,0);
        return ans;
    }
}