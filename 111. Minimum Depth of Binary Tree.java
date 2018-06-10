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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int minDepth = 1;
        //Use 2 queue's to keep track of depth
        Queue<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        Queue<TreeNode> queue2 = new ArrayDeque<TreeNode>();
    
        queue1.add(root);
        while (true){
            while (!queue1.isEmpty()){
                TreeNode next = queue1.poll();
                if ((next.left == null) && (next.right == null)) return minDepth;     
                if (next.left != null) queue2.add(next.left);
                if (next.right != null) queue2.add(next.right);
            }
            //Now that we have finished one depth we move all of queue2 nodes to queue1 and start on the next depth
            //of the tree
            while (!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
            minDepth++;
        }
    }
}
    
    