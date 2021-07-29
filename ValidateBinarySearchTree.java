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
    
  Approach 1:
 -------------
    static int prev = Integer.MIN_VALUE; 
    public boolean isValidBST(TreeNode root) {
    
        List<Integer> list = new ArrayList<>();
        checkBST(root,list);
        for(int i = 1;i < list.size(); i++){
           if(list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }
    private List<Integer> checkBST(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return list;
        
        checkBST(root.left,list);
        list.add(root.val);
        checkBST(root.right,list);
        return list;
    }

  Approach 2:
 ------------
    public boolean isValidBST(TreeNode root){
        
        return validate(root,null,null);
    }
    private boolean validate(TreeNode root, Integer low, Integer high){
        
        if(root == null)
            return true;
        if(low != null && root.val <= low || high != null && root.val >= high) return false;
        
        return validate(root.left,low,root.val) && validate(root.right,root.val,high);
    }
}
