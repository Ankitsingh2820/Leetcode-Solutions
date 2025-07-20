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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return list;}
            stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode current=stack.pop();
            list.add(current.val);
            if(current.right!=null)
            {
                stack.push(current.right);
            }
            if(current.left!=null)
            {
                stack.push(current.left);
            }
        }
        return list;
    }
    public List<Integer> preorderTraversalr(TreeNode root) 
    {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }
    void preorder(TreeNode root,List<Integer> list)
    {
        if(root==null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    
    }
}