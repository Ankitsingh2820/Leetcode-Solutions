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
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        // Map value to index in inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     map);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd,
                           HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd)
            return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);
        int leftSize = index - inStart;

        root.left = build(postorder, postStart, postStart + leftSize - 1,
                          inorder, inStart, index - 1, map);

        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                           inorder, index + 1, inEnd, map);

        return root;
    }
}
