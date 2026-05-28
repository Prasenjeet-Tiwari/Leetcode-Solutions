class Solution {
    // Use an array of size 1 to track the index across recursive calls cleanly
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, new int[]{0}, Integer.MAX_VALUE);
    }
    
    private TreeNode constructBST(int[] preorder, int[] idx, int bound) {
        // If we've consumed the array or the current value exceeds the BST boundary for this subtree
        if (idx[0] >= preorder.length || preorder[idx[0]] > bound) {
            return null;
        }
        
        // Create the root node for this subtree
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++; // Move to the next element in the preorder array
        
        // For the left child, the maximum allowed value is the current root's value
        root.left = constructBST(preorder, idx, root.val);
        
        // For the right child, it inherits the same upper bound constraint as the current root
        root.right = constructBST(preorder, idx, bound);
        
        return root;
    }
}