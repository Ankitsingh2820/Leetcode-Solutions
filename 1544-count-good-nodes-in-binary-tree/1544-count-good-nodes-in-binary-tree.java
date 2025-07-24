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
    public int goodNodes(TreeNode root) 
    {
       int result=helper(root,Integer.MIN_VALUE) ;
       return result;
    }
    private int helper(TreeNode root,int currentmax)
    {
        if(root==null)
        {
            return 0;
        }
        int left=helper(root.left,Math.max(root.val,currentmax));
        int right=helper(root.right,Math.max(root.val,currentmax));
         int result=left+right;
        if(root.val>=currentmax)
        {
           result= result+1;
        }
        return result;
    }
}