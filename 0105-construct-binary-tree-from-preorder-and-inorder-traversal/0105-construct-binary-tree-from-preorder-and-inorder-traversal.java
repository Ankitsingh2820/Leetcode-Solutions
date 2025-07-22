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
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a hashmap to store value -> index relations for inorder
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Get the current root value
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of root in inorder to divide left and right subtree
        int inorderIndex = inorderIndexMap.get(rootVal);

        // Build left and right subtree recursively
        root.left = buildSubTree(preorder, left, inorderIndex - 1);
        root.right = buildSubTree(preorder, inorderIndex + 1, right);

        return root;
    }
}