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
    public void flatten(TreeNode root) {
        TreeNode previousNode = null;
        TreeNode currentNode = null;
        if(currentNode == null){
            return ;
        }
        flatten(currentNode.right);
        flatten(currentNode.left);
        currentNode.right = previousNode;
        currentNode.left = null;
        previousNode = currentNode;  
    }
}
