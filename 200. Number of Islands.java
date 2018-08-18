class Solution {
    
    public boolean [][] seen;
    
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid.length == 0) return 0;
        seen = new boolean[grid.length][grid[0].length];
        for (int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if ((grid[row][col] == '1') && (seen[row][col] == false)){
                    numIslands++;
                    System.out.println("start check from " + row + " " + col);
                    dfs(row, col, grid);
                }
            }
        }    
        return numIslands;
    }
    
    public void dfs(int row, int col, char[][] grid){
        System.out.println(row + " : " + col);
        //check up
        if(row-1 >= 0){
            if(grid[row-1][col] == '1' && seen[row-1][col] == false){
                seen[row-1][col] = true;
                dfs(row-1, col, grid);
            }
        }
        
        //check down
        if(row+1 < grid.length){
            if(grid[row+1][col] == '1' && seen[row+1][col] == false){
                seen[row+1][col] = true;
                dfs(row+1, col, grid);
            }
        }
        
        //check left
        if(col-1 >= 0){
            if(grid[row][col-1] == '1' && seen[row][col-1] == false){
                seen[row][col-1] = true;
                dfs(row, col-1, grid);
            }
        }
        
        //check right
        if(col+1 < grid[0].length){
            if(grid[row][col+1] == '1' && seen[row][col+1] == false){
                seen[row][col+1] = true;
                dfs(row, col+1, grid);
            }
        }
    }
}