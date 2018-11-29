class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 1; i < board.length-1; i++){
            for (int j = 1; j < board[0].length-1; j++){
                if(board[i][j] == 'O' && !seen[i][j]){
                    if(DFScheck(board, seen, i, j) == false){
                        DFStoX(board, i, j);
                    }
                }
            }
        }
        return;
    }
    
    //Checks if this area of 0's is surrounded by checking if it reaches an edge through dfs
    //returns true if it reaches an edge
    public boolean DFScheck(char[][] board, boolean[][] seen, int i, int j){
        if(seen[i][j] || board[i][j] == 'X') return false;
        
        //return true if this dfs is attached to an edge
        if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1){
            if (board[i][j] == 'O') return true;
            return false;
        }
        
        //check each direction -- Note single | is used so that is doesn't short circuit
        //we must go through the entire DFS of non edge nodes to make sure they are marked
        //as seen
        seen[i][j] = true;
        return DFScheck(board, seen, i+1, j) | DFScheck(board, seen, i, j+1) 
            | DFScheck(board, seen, i-1, j) | DFScheck(board, seen, i, j-1);
    }
    
    //Changes all X's to 0's in a DFS starting from i, j
    public void DFStoX(char[][] board, int i, int j){
        // never change an edge and don't dfs on an X
        if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) return;
        if (board[i][j] == 'X') return;
        
        else{
            board[i][j] = 'X';
            DFStoX(board, i+1, j);
            DFStoX(board, i, j+1);
            DFStoX(board, i-1, j);
            DFStoX(board, i, j-1);
        }
    }
}