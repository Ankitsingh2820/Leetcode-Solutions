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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();
    if(root==null) return result;
    Queue<TreeNode> que=new LinkedList<>();
    que.offer(root);
    boolean leftToRight=true;
    while(!que.isEmpty())
    {
        int level1=que.size();
        LinkedList<Integer> level=new LinkedList<>();
        for(int i=0;i<level1;i++)
        {
            TreeNode node=que.poll();
            
                if (leftToRight) {
                    level.addLast(node.val);  // Add to end
                } else {
                    level.addFirst(node.val); // Add to front
                }
            if(node.left!=null)que.offer(node.left);
            if(node.right!=null)que.offer(node.right);
        }
    result.add(level);
        leftToRight=!leftToRight;
    }
return result;

    }
}