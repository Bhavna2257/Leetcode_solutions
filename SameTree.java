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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        Queue<TreeNode> pnode = new LinkedList<>();
        Queue<TreeNode> qnode = new LinkedList<>();
        
        pnode.add(p);
        qnode.add(q);
        while(!pnode.isEmpty() && !qnode.isEmpty())
        {
            TreeNode currp = pnode.remove();
            TreeNode currq = qnode.remove();
            if(currp == null && currq == null)
                continue;
            if(currp == null || currq == null)
                return false;
            if(currp.val != currq.val)
                return false;
            
            // if(currp.left == null && currq.left != null)
            //     return false;
            // else if(currp.left != null && currq.left == null)
            //     return false;
            // else if(currp.right == null && currq.right != null)
            //     return false;
            // else if(currp.right != null && currq.right == null)
            //     return false;
            
            // if(currp.left != null && currq.left != null)
            // {
                pnode.add(currp.left);
                qnode.add(currq.left);
            //}
            
            // if(currp.right != null && currq.right != null)
            // {
                pnode.add(currp.right);
                qnode.add(currq.right);
            //}
         }
        
        return true;
    }
}
