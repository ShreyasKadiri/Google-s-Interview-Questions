/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode addOneRow(TreeNode root, int v, int d) 
    {
        if (d == 1) 
        {
        TreeNode curr=new TreeNode(v);
        curr.left=root;
        return curr;
        }
        addNodes(root, 2, d, v);
        return root;
    }
    
    
    
    
    private void addNodes(TreeNode node, int currentDepth, int targetDepth, int val) 
    {
        if (currentDepth==targetDepth) 
        {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
            return;
        }
        if (node.left != null) {
            addNodes(node.left, currentDepth + 1, targetDepth, val);
        }
        if (node.right != null) {
            addNodes(node.right, currentDepth + 1, targetDepth, val);
        }
    }
}
