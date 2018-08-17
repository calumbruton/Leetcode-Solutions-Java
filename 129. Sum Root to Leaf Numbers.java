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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(root, 0, ans);
        int ret = 0;
        for (int x : ans) ret+=x;
        return ret;
    }
    
    public void helper(TreeNode root, int sum, ArrayList<Integer> ans){
        sum += root.val;
            
        if(isLeaf(root)){
            ans.add(sum);
        }
        
        if(root.left != null){
            int left = sum*10;
            helper(root.left, left, ans);
        }
        
        if(root.right != null){
            int right = sum*10;
            helper(root.right, right, ans);
        }
    }
    
    public boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
}