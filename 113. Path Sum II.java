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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> temp = new LinkedList<Integer>();
        rec_PathSum(root, sum, temp, ans);
        return ans;
    }
    
    public void rec_PathSum(TreeNode root, int sum, LinkedList<Integer> temp, List<List<Integer>> ans){
        if (root == null) return;
        int v = sum-root.val;
        if (v == 0 && root.left == null && root.right == null){
            //make a copy of temp to add to the answer -- shallow copy but integers are primative
            temp.add(root.val);
            LinkedList<Integer> clone = (LinkedList) temp.clone();
            ans.add(clone);
            temp.removeLast();
            return;
        }
        else
            temp.add(root.val);
            rec_PathSum(root.left, v, temp, ans);
            rec_PathSum(root.right, v, temp, ans);
            temp.removeLast();
            return;
    }
}

