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
    int maxDiameter = 0;  // To track the maximum among all nodes

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    public int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        // 1. Calculate left height and right height
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // 2. Calculate diameter for this node
        int diameterAtNode = leftHeight + rightHeight;

        // 3. Update the global maximum
        maxDiameter = Math.max(maxDiameter, diameterAtNode);

        // 4. Return the height of this node (so parent can use it)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
