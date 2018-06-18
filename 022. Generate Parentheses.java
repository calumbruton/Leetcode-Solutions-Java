class Solution {
    public List<String> generateParenthesis(int n) {
        //Use backtracking
        ArrayList <String> ans = new ArrayList<String>();
        backtrack(n, n*2, ans, new StringBuilder(), 0);
        return ans;
    }
    
    public void backtrack(int n, int x, List<String> ans, StringBuilder bracks, int open){
        //System.out.println(x + ": " + bracks);
        if (x==0){
            //System.out.println("yup: " + open);
            if (open == 0)
                ans.add(bracks.toString());
            return;
        }
        //try a closing bracket
        if(open > 0){
            x--;
            open--;
            bracks.append(")");
            backtrack(n, x, ans, bracks, open);
            bracks.setLength(bracks.length()-1);
            x++;
            open++;
        }
        //try an opening bracket
        if(open < x){
            x--;
            open++;
            bracks.append("(");
            backtrack(n, x, ans, bracks, open);
            bracks.setLength(bracks.length()-1);
            x++;
            open--; 
        }
    }
}