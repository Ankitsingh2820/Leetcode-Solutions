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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: x -> Map<y, PriorityQueue of values>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue for BFS: stores node and its (x, y) coordinates
        Queue<Pair<TreeNode, int[]>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, new int[]{0, 0}));

        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> pair = queue.poll();
            TreeNode node = pair.getKey();
            int x = pair.getValue()[0];
            int y = pair.getValue()[1];

            // Insert into the map
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            // Traverse children
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, new int[]{x - 1, y + 1}));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, new int[]{x + 1, y + 1}));
            }
        }

        // Build result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            result.add(col);
        }

        return result;
    }
}
