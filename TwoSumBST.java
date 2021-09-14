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
        Set<Integer> complementSet = new HashSet<>();
        Boolean flag = false;
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Inorder1(root1 , target);
        return Inorder2(root2 , target);
        
    }
    
    public void Inorder1(TreeNode root1 , int target) {
        if(root1 == null) return;
        Inorder1(root1.left , target);
        complementSet.add(target - root1.val);
        Inorder1(root1.right , target);
    }
    
    public Boolean Inorder2(TreeNode root2 , int target) {
        if(root2 != null) {
        Inorder2(root2.left , target);
        if(complementSet.contains(root2.val)) flag = true;
        Inorder2(root2.right , target);
        }
        
        return flag == true ? true : false;
    }
}
