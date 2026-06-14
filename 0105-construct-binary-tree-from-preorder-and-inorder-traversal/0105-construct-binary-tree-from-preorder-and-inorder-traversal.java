class Solution {

    int preIdx = 0;

    public TreeNode construct(int[] preorder, int[] inorder,
                              int start, int end) {

        if (start > end)
            return null;

        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);

        int pos = start;
        while (pos <= end && inorder[pos] != val) {
            pos++;
        }

        root.left = construct(preorder, inorder, start, pos - 1);
        root.right = construct(preorder, inorder, pos + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
}