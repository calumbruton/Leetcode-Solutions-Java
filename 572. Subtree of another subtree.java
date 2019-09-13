/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Over the top memory efficient solution

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
//         DFS through tree s
        int searchVal = t.val;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(s);
        while(!stack.empty()){
            TreeNode next = stack.pop();
            // If same value as root of t check if they are identical
            if (next.val == searchVal){
                if(isSameTree(next, t)){
                    return true;
                }
            }
            if(next.left != null) stack.push(next.left);
            if(next.right != null) stack.push(next.right);
        }
        // The same subtree couldn't be found
        return false;
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t){
        Stack<TreeNode> stackS = new Stack<TreeNode>();
        Stack<TreeNode> stackT = new Stack<TreeNode>();
        stackS.push(s);
        stackT.push(t);
        while (!stackS.empty() || !stackT.empty()){
            if (stackS.size() != stackT.size()) return false;
            TreeNode nodeS = stackS.pop();
            TreeNode nodeT = stackT.pop();
            if(nodeS.val != nodeT.val) return false;
            if(nodeS.left != null) stackS.push(nodeS.left);
            if(nodeS.right != null) stackS.push(nodeS.right);
            if(nodeT.left != null) stackT.push(nodeT.left);
            if(nodeT.right != null) stackT.push(nodeT.right);   
        }
        return true;
    }
}