class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        // Base Case: The key doesn't exist in the tree
        if (root == null) {
            return null;
        }

        // 1. Navigate the tree to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Assigning the result updates the pointer
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        // 2. Found the node! Handle the deletion
        else {
            // Case 1 & 2: Leaf node or Node with only one child
            if (root.left == null) {
                return root.right; // If left is null, right child takes its place
            } else if (root.right == null) {
                return root.left;  // If right is null, left child takes its place
            }

            // Case 3: Node with two children
            // Get the Inorder Successor (smallest value in the right subtree)
            TreeNode successor = findMin(root.right);
            
            // Replace the current node's value with the successor's value
            root.val = successor.val;
            
            // Delete the successor node from the right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Helper method to find the leftmost (smallest) node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}