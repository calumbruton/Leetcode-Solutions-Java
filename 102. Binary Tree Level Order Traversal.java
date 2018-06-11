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
    public List<List<Integer>> levelOrder(TreeNode root) {  
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null) return ans;
        
        //Use two queues
        Queue <TreeNode> queue1 = new ArrayDeque <TreeNode>();
        Queue <TreeNode> queue2 = new ArrayDeque <TreeNode>();
        
        queue1.add(root);
        while (true){
            List<Integer> level = new ArrayList<Integer>();
            while (!queue1.isEmpty()){
                TreeNode next = queue1.poll();
                level.add(next.val);
                if (next.left != null) queue2.add(next.left);
                if (next.right != null) queue2.add(next.right);
            }
            while(!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
            
            //We have finished one level of the tree add it to the ans list
            ans.add(level);
            
            //If queue 1 is still empty we have seen every node
            if (queue1.isEmpty()) return ans;
        } 
    }
}