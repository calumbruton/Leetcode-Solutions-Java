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
    public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> s = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            while (true) {
                if (root!=null) {
                    s.push(root);
                    root=root.left;
                } else {
                    if (s.isEmpty()) return res;
                    root = s.pop();
                    res.add(root.val);
                    root=root.right;
                }
            }
        }
    }