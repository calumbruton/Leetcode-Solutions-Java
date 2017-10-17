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
    public List<Integer> inorderTraversal(TreeNode root) {
        //Create an array list
        List<Integer> retList = new ArrayList<Integer>();
        inorderRecursiveTraversal(root, retList);
        return retList;
     
    }
    public void inorderRecursiveTraversal(TreeNode root, List<Integer> retList) {
        if(root != null){
            inorderRecursiveTraversal(root.left, retList);
            retList.add(root.val);
            inorderRecursiveTraversal(root.right, retList);  
        }
    }
}