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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if (root != null){ 
            helper(root, String.valueOf(root.val), ans);
        }
        return ans;
    }
    
    public void helper(TreeNode root, String curr, List<String> ans) {
        if (root.left == null && root.right == null){
            ans.add(curr);
        }
        if (root.left != null){
            helper(root.left, curr + "->" + root.left.val, ans);
        }
        if (root.right != null){
            helper(root.right, curr + "->" + root.right.val, ans);
        }
    }
    
}