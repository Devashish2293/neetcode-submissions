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
    private int index;  

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }


    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodes = data.split(",");
        index = 0;  
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(String[] nodes) {
        if (nodes[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }
}
