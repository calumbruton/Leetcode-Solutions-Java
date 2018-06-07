class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        backtrack(res, ans, 0, S, new HashSet<String>());
        return ans;
    }
    
    
    private boolean isFibo(List<Integer> res){
        for(int i = 2; i < res.size() ; ++i){
            if(res.get(i) != res.get(i-1)+res.get(i-2))return false;
        }
        return true; 
    }
    
    public void backtrack(List<Integer> res, List<Integer> ans,int pos, String S , Set<String> set){
        //Base case of backtracking if more than 2 vals in res and fib than add them to ans
        //we need ths isFibo function because if the final value added is a 0 
        if(pos == S.length()) {
            if(res.size() >= 3 && isFibo(res)) {
                ans.clear(); 
                for(int num : res)ans.add(num);
            }
            return ; 
        }
        
        //Case 1: A 0 is found
        
        if(S.charAt(pos) == '0'){
            res.add(0);
            backtrack(res,ans, pos+1, S, set);
            res.remove(res.size()-1);
            return; 
        } 
        
        for (int i = pos; i<S.length(); i++){
            
            //Case 2: If 2 or more numbers are already in the result than check the last 2 numbers sum and see if the next chars                       of the String is this number, if it is then add it to the result and keep going
            if (res.size()>=2){
                int a = res.get(res.size()-1);
                int b = res.get(res.size()-2);
                if(set.contains(a + "-" + b))return; 
                else set.add(a + "-" + b);
                long next = a+b;
                if(next > Integer.MAX_VALUE)return; 
                else {
                    String temp = String.valueOf(next) ;
                    if(S.substring(pos).startsWith(temp)){
                        res.add((int)next);
                        backtrack(res, ans, pos + temp.length(), S, set);
                        res.remove(res.size()-1);
                    }
                }
            }
        
        
            //Case 3: Try every possible range of values 
            else{
                long val = Long.parseLong(S.substring(pos, i+1)); 
                if(val > Integer.MAX_VALUE)return; 
                else{
                    res.add((int)val);
                    backtrack(res, ans, i + 1, S, set);
                    res.remove(res.size()-1);
                }
            }
        
        }
    }
}
