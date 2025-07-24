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
    private int sum = 0; // Class-level variable to store the result

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high); // Start recursion
        return sum;
    }

    private void helper(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            if (low < node.val) {
                helper(node.left, low, high);
            }
            if (node.val < high) {
                helper(node.right, low, high);
            }
        }
    }
}
