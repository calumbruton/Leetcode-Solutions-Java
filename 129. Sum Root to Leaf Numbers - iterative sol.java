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
        int ans = 0;
        Stack<Ele> stack = new Stack<Ele>();
        if (root == null) return 0;
        
        stack.push(new Ele(root,root.val));
        while(!stack.isEmpty()){
            Ele e = stack.pop();
            root = e.root;
            if (root.left == null && root.right == null){
                ans+=e.sum;
            }
            if(root.left != null){
                stack.push(new Ele(root.left, e.sum*10+root.left.val));
            }
            if(root.right != null){
                stack.push(new Ele(root.right, e.sum*10+root.right.val));
            }
        } 
        return ans;
    }
    
    class Ele{
        TreeNode root = null;
        int sum = 0;
        
        public Ele(TreeNode root, int sum){
            this.root = root;
            this.sum = sum;
        }
    }
}