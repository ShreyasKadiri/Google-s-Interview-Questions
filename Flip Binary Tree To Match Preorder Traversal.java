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
    
    List<Integer> flipped;
    int index;
    int[] voyage;
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        index =0;
        flipped = new ArrayList();
        
        dfs(root);
        if(!flipped.isEmpty() && flipped.get(0) == -1){
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }
    
    public void dfs(TreeNode node){
        if(node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }
            if(index < voyage.length && node.left != null && node.left.val != voyage[index]){
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
        
    }
