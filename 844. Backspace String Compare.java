class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack <Character> stackS = new Stack <Character>();
        Stack <Character> stackT = new Stack <Character>();
        
        for (char c : S.toCharArray()){
            if (c != '#') stackS.push(c); 
            else if (!stackS.empty()) stackS.pop();
        }           
        
        for (char c : T.toCharArray()){
            if (c != '#') stackT.push(c);
            else if (!stackT.empty()) stackT.pop();
        }      
        
        while (!(stackS.empty())){
            if (stackT.empty()) return false;
            if (stackT.pop() != stackS.pop()) return false;
        }
        return (stackT.empty()) ? true : false;
    }
}