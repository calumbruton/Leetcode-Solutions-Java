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
    class ResultType {
            TreeNode node;
            int sum;
            int size;
            public ResultType(TreeNode node, int sum, int size) {
                this.node = node;
                this.sum = sum;
                this.size = size;
            }
        }
    
    private ResultType result = null;
    
    public TreeNode maxDepth(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        ResultType rootResult = helper(root);
        return result.node;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, 0);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        
        ResultType currResult = new ResultType(
                    root, 
                    leftResult.sum + rightResult.sum + root.val, 
                    leftResult.size + rightResult.size + 1);
    
        currResult.sum = currResult.sum/currResult.size;
        if (result == null 
            || currResult.sum > result.sum ) {
            result = currResult;
        }
        
        return currResult;
    }
}