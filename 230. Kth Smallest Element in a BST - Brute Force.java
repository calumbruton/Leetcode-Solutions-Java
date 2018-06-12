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
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans;
        ans = kthSmallestRec(root, k);
        //for (int num : ans) System.out.println(num);
        return ans.get(k-1);
    }

    public List<Integer> kthSmallestRec(TreeNode root, int k) {
        //pre-order traversal until kth node
        List<Integer> res = new ArrayList<Integer>();
        
        if (root.left != null) res.addAll(kthSmallestRec(root.left, k));
        res.add(root.val);
        if (root.right != null) res.addAll(kthSmallestRec(root.right, k));
        return res;
    }
}