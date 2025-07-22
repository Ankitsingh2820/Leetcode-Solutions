/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
       int pval=p.val;
       int qval=q.val;
       while(root!=null)
       {
        if(pval<root.val && q.val<root.val)
        {
            root=root.left;
        }
        else if(pval>root.val && qval>root.val)
        {
            root=root.right;
        }
        else
        {
            return root;
        }
       }
return null;
        
    }
}