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

    //if max pathy exist in some local path
    int localMax= Integer.MIN_VALUE;;

    public int PathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0, PathSum(root.left)); //either include or exc that why 0 is taken
        int right = Math.max(0, PathSum(root.right));

        int curr = root.val;

        // complete path through current node
        int fullPath = curr + left + right;

        localMax = Math.max(localMax, fullPath);

        // return single branch upward
        return curr + Math.max(left, right);

    }
    public int maxPathSum(TreeNode root) {

        int ans=PathSum(root);
        return Math.max(ans,localMax);  //so return if max path is throught top root or local root
        
    }
}