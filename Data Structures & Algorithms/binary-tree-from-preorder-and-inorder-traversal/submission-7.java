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
    Map<Integer,Integer> inMap = new HashMap();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++){
            inMap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int start,int end){

        if(start>end)
            return null;

        int rootVal = preorder[preIndex++];
        
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inMap.get(rootVal);

        root.left = build(preorder,start,rootIndex-1);
        root.right = build(preorder,rootIndex+1 , end);
        return root;
    }
}
