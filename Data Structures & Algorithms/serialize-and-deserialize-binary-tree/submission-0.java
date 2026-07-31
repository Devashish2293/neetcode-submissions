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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    if (root == null) return "";


    Queue<TreeNode> queue = new LinkedList<>();
    StringBuilder str = new StringBuilder();
    queue.offer(root);


    while (!queue.isEmpty()) {
        TreeNode curr = queue.poll();

 
        if (curr == null) {
            str.append("null");
        } else {
            str.append(curr.val);
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        if (!queue.isEmpty()) {
            str.append(",");
        }
    }

    return str.toString();
}
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals(""))
        return null;

        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode parent = queue.poll();

            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }
}
