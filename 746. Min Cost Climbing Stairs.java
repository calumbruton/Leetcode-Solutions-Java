class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //Bottom up approach
        int s1 = cost[0];
        int s2 = cost[1];
        
        for (int i = 2; i < cost.length; i++){
            int ans = Math.min(s1, s2) + cost[i];
            s1 = s2;
            s2 = ans;
        }
        
        return Math.min(s1, s2);
    }
}