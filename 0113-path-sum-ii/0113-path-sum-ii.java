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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // Add current node to the path
        path.add(node.val);
        remaining -= node.val;

        // Check if it's a leaf and remaining sum is 0
        if (node.left == null && node.right == null && remaining == 0) {
            result.add(new ArrayList<>(path)); // Copy to avoid reference issues
        }

        // Recurse left and right
        dfs(node.left, remaining, path, result);
        dfs(node.right, remaining, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}
