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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root!=null){
        traverseAllPaths(root, "", result);           
        }
        return result;
    }
    
    public void traverseAllPaths(TreeNode root, String currentPath, List<String> result){
     if(root.left==null && root.right==null){
            result.add(currentPath+root.val);
        }
        
        if(root.left!=null){
         traverseAllPaths(root.left, currentPath+root.val+"->", result);
     }
      
        if(root.right!=null){
         traverseAllPaths(root.right, currentPath+root.val+"->", result);
     }
      
        return ;
    }
}
