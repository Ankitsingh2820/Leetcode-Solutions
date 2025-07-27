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
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Check if x and y are children of same parent
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.add(node.left);
                    if (node.left.val == x) foundX = true;
                    if (node.left.val == y) foundY = true;
                }

                if (node.right != null) {
                    queue.add(node.right);
                    if (node.right.val == x) foundX = true;
                    if (node.right.val == y) foundY = true;
                }
            }

            // If both found at same level with different parents
            if (foundX && foundY) return true;

            // If only one found at current level
            if (foundX || foundY) return false;
        }

        return false;
    }
}
