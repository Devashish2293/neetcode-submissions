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
   public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
       
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        boolean currentBalanced = Math.abs(leftHeight - rightHeight) <= 1;
        

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        
        return currentBalanced && leftBalanced && rightBalanced;
    }

    public int getHeight(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }

        return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }

}
