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

    // stores maximum diameter found so far
    // diameter = number of edges in longest path
    int localMax = 0;

    // DFS function returns HEIGHT of subtree
    public int dfs(TreeNode root) {

        // base case
        // height of null node = 0
        if (root == null) {
            return 0;
        }

        // recursively find left subtree height
        int left = dfs(root.left);

        // recursively find right subtree height
        int right = dfs(root.right);

        /*
            Diameter through current node:

                    root
                   /    \
                left   right

            longest path through current node
            = left height + right height

            since diameter is measured in EDGES
        */
        int currDiameter = left + right;

        // update global maximum diameter
        localMax = Math.max(localMax, currDiameter);

        /*
            return height of current subtree

            current height =
            1 (current node) +
            maximum(left subtree height, right subtree height)
        */
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        // perform postorder DFS traversal
        dfs(root);

        // final maximum diameter
        return localMax;
    }
}