class Solution {
    
    List<List<Integer>> res;
    Set<String> seen = new HashSet<String>();
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(candidates, target, -1, 0, ans);
        return res;
    }
    
    public void backtrack(int [] candidates, int target, int pos, int sum, List<Integer>ans){

            
        //if the sum is equal to the target add this solution to the result
        if (sum == target){
            //Make a shallow copy of ans to add to res
            StringBuilder comboBuilder = new StringBuilder();
            for(int num: ans){
                comboBuilder.append(num + "-");
            }
            //If the combination is unique add it
            String combo = comboBuilder.toString();
            if (!seen.contains(combo))
                this.res.add(new ArrayList<Integer>(ans));
            seen.add(combo);
            return;
        }
    
        //Iterate through all possible solutions
        for (int i = pos+1; i < candidates.length; i++){
            if (sum+candidates[i] <= target){
                ans.add(candidates[i]);
                backtrack(candidates, target, i, sum+candidates[i], ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}