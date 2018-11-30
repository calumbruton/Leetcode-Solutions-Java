class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0) return false;
        
        boolean[][] seen = new boolean [board.length][board[0].length];
        char[] wordArr = word.toCharArray();
        
        //get starting charachter
        char ch = wordArr[0];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == ch){
                    if(DFS(board, seen, i, j, wordArr, 0)) return true;
                }
            }
        } //end of for
        
        return false;
        
    }
    
    public boolean DFS(char[][] board, boolean[][] seen, int i, int j, char[] wordArr, int loc){
        //if the whole word has been reached return true
        if (loc >= wordArr.length) return true;
        
        //if index is not eligible or letter has been seen already return false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j]) return false;
        
        // otherwise check the location contains the next letter and continue dfs or return false
        char ch = wordArr[loc];
        if (board[i][j] == ch){
            //System.out.println(board[i][j] + " " + i + " " + j);
            seen[i][j] = true;
            
            //check all 8 locations around the square for the next letter, if it
            if(DFS(board, seen, i-1, j, wordArr, loc+1) 
                || DFS(board, seen, i+1, j, wordArr, loc+1)
                || DFS(board, seen, i, j-1, wordArr, loc+1) 
                || DFS(board, seen, i, j+1, wordArr, loc+1)) return true;
            
            seen[i][j] = false; 
            return false;
        }
        else return false;
    }
}