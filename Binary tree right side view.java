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
    public List<Integer> rightSideView(TreeNode root) {
     List<Integer> rightSideViewTraversal = new ArrayList<Integer>();
        if(root==null){
            return rightSideViewTraversal;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int value = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                TreeNode poppedNode = queue.poll();
                if(poppedNode !=null){
                    value = poppedNode.val;
                    if(poppedNode.left!=null){
                        queue.offer(poppedNode.left);
                    }
                     if(poppedNode.right!=null){
                        queue.offer(poppedNode.right);
                    }
                }
            }
                if(value!=Integer.MIN_VALUE){
                    rightSideViewTraversal.add(value);
                }
            }
        return rightSideViewTraversal;
    }
}
