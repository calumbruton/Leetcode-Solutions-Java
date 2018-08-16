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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int v = sum-root.val;
        if (v == 0 && root.left == null && root.right == null) return true;
        else return (hasPathSum(root.left, v) || hasPathSum(root.right, v));
    }
}