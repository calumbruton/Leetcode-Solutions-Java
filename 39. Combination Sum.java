class Solution {
    
    List<List<Integer>> res;
        
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        backtrack(candidates, target, 0, 0, ans);
        return res;
    }
    
    public void backtrack(int [] candidates, int target, int pos, int sum, List<Integer>ans){

            
        //if the sum is equal to the target add this solution to the result
        if (sum == target){
            //Make a shallow copy of ans to add to res
            List<Integer> temp = new ArrayList<Integer>();
            for(int num: ans) temp.add(num);
            this.res.add(temp);
            return;
        }
    
        //Iterate through all possible solutions
        for (int i = pos; i < candidates.length; i++){
            if (sum+candidates[i] <= target){
                ans.add(candidates[i]);
                backtrack(candidates, target, i, sum+candidates[i], ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}