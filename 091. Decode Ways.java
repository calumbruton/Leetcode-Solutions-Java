class Solution {
    public int numDecodings(String s) {
        Inte res = new Inte(0);
        if (s.length() > 0) backtrack(s, res, 0);
        return res.x;
    }
    
    public void backtrack(String s, Inte res, int pos){
        if (pos == s.length()){
            res.x++;
        }
        else{
            //Valid single digit number
            if (s.charAt(pos) != '0') backtrack(s, res, pos+1); 
            
            //Valid 2 digit number
            if (pos+2 <= s.length()){
                if (s.charAt(pos) == '1' || ((s.charAt(pos) == '2' && "0123456".indexOf(String.valueOf(s.charAt(pos+1))) != -1))){
                        backtrack(s, res, pos+2);
                }
            }
        }
        return;
    }   
}

class Inte{
        public int x=0;
        public Inte(int x){
            this.x = x;
        }
    
    }

