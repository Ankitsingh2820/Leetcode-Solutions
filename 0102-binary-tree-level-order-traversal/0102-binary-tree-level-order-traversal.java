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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        Queue<TreeNode> que= new LinkedList<>();
        List<List<Integer>> blist=new ArrayList<>();
        if(root==null) return blist;
        que.offer(root);
        while(!que.isEmpty())
        {
            int level=que.size();
            List<Integer> slist=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                if(que.peek().left!=null)
                {
                    que.offer(que.peek().left);

                }
                if(que.peek().right!=null)
                {
                    que.offer(que.peek().right);
                }
                slist.add(que.poll().val);


            }
            blist.add(slist);
        }
        return blist;
    }
}