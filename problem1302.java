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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            
            while(size != 0) {
                TreeNode currNode = queue.remove();
                sum += currNode.val;
                
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
                size--;
            }
        }
       return sum; 
    }
}

Time Complexity : O(n) Since we need to visit every node
