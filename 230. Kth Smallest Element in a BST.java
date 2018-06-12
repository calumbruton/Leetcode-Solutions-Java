/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int i = 1;
    int val = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRec(root,k);
        return this.val;
    }

    public void kthSmallestRec(TreeNode root, int k) {
        
        //pre-order traversal until kth node      
        if (root.left != null) kthSmallestRec(root.left, k);
        if(i == k) this.val = root.val;
        this.i++;
        if (i > k) return;
        if (root.right != null) kthSmallestRec(root.right, k);
    }
}