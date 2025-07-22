/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelp(root, sb);
        return sb.toString();
    }

    // Helper method for serialization
    private void shelp(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        shelp(root.left, sb);
        shelp(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(arr));
        return dhelp(queue);
    }

    // Helper method for deserialization
    private TreeNode dhelp(Queue<String> queue) {
        String nodeData = queue.poll();
        if (nodeData.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeData));
        node.left = dhelp(queue);
        node.right = dhelp(queue);
        return node;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));