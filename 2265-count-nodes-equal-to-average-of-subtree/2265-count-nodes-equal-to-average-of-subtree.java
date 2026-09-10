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
    int ans = 0;

    public int[] tree(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        
        int[] leftRes = tree(root.left);
        int[] rightRes = tree(root.right);
        
        int thisval = leftRes[0] + rightRes[0] + root.val;
        int count = leftRes[1] + rightRes[1] + 1;
        
        int curr = root.val;
        
        if(thisval / count == curr){
            ans += 1;
        }
        
        return new int[]{thisval, count};
    }

    public int averageOfSubtree(TreeNode root) {
        tree(root);
        return ans;
    }
}