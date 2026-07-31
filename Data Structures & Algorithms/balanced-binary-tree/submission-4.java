class Solution {
    private boolean balanced = true;  // Global flag

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // If the difference is > 1, mark as unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}