class Solution {
    String [] digs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        backtrack(digits, 0, "", res);
        return res;
    }
    
    public void backtrack(String digits, int pos, String ans, List<String> res){
        
        if(pos == digits.length()){
            if (ans.length() != 0)
                res.add(ans);
            return;
        }
        
        int num = Character.getNumericValue(digits.charAt(pos));
        int idx = num-2;
        
        backtrack(digits, pos+1, ans+this.digs[idx].charAt(0), res);
        backtrack(digits, pos+1, ans+this.digs[idx].charAt(1), res);
        backtrack(digits, pos+1, ans+this.digs[idx].charAt(2), res);
        
        if (this.digs[idx].length() == 4) 
            backtrack(digits, pos+1, ans+this.digs[idx].charAt(3), res);
    }
}