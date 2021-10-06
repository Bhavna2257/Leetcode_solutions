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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return createBST(0 , nums.length - 1);
        
    }
    
    private TreeNode createBST(int i , int j) {
        if(i > j) return null;
        
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(i , mid - 1);
        root.right = createBST(mid + 1 , j);
        
        return root;
        
    }
}
