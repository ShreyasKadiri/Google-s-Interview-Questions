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
    int cameras = 0;
    int notMonitored = 0;
    int monitoredWithCamera = 2;
    int monitoredNoCamera = 1;
    
    public int minCameraCover(TreeNode root) {
        if(root==null){
            return 0;
        }
        int top=dfs(root);
        return cameras + (top == notMonitored ? 1:0);
    }
    
    public int dfs(TreeNode root) {
        if (root==null) {
             return monitoredNoCamera;
        }
      
        int leftMove=dfs(root.left);
        int rightMove=dfs(root.right);
        
        if(leftMove==monitoredNoCamera && rightMove==monitoredNoCamera){
            return notMonitored;
        }else if (leftMove==notMonitored || rightMove==notMonitored){
            cameras++;
            return monitoredWithCamera;
        }else { 
            return monitoredNoCamera;
        } 
    }
}
