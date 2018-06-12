class Solution {
    List<String> res;
    
    public List<String> letterCasePermutation(String S) {
        this.res = new ArrayList<String>();
        backtrack(S, "", 0);
        return this.res;
    }
    
    public void backtrack(String S, String ans, int idx){
        //full string made
        if (idx == S.length()){
            this.res.add(ans);
            return;
        }

        char c = S.charAt(idx);
        System.out.println(c);
        
        if (Character.isLetter(c)){
            backtrack(S, ans + Character.toLowerCase(c), idx+1);
            backtrack(S, ans + Character.toUpperCase(c), idx+1);
        }
        
        else{
            backtrack(S, ans + c, idx+1);
        }
        
    }
}
