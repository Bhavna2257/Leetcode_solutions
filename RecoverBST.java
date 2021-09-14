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
    
    public void recoverTree(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        inorder(root , list);
        int[] swapped = swapElements(list);
        
        treeRecovery(root , 2 , swapped[0] , swapped[1]);
        
    }
    private int[] swapElements(List<Integer> list) {
        int x = 0 , y = 0;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i - 1)) {
                y = list.get(i);
                if(x == 0) x = list.get(i - 1);
                else break;
            } 
        }
        return new int[]{x , y};
    }
    private void inorder(TreeNode root , List<Integer> list) {
       
        if(root == null) return;
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
        
    }
    private void treeRecovery(TreeNode root , int count , int x , int y) {
        if(root != null) {
        if(root.val == x || root.val == y) {
           root.val = root.val == x ? y : x;
           if(--count == 0) return;
        } 
        treeRecovery(root.left , count , x , y);
        treeRecovery(root.right, count , x , y);
        }
        
    }
}
