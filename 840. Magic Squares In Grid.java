class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;
        //Starting from the top left corner we need to check a 3x3 square
        //we then loop until we are at grid[i].length-3 and down grid.length-3
        for (int r = 0; r<grid.length-2; r++){
            for (int c = 0; c<grid[0].length-2; c++){
                System.out.println(grid[r][c]);
                if (isMagicSquare(r,c,grid)) count++;
            }
        }
        return count;
    }
    
    
    public boolean isMagicSquare(int x,int y,int[][] grid){
        if(grid[x+1][y+1]!=5) return false;
        
        int[] valid=new int[16];
        
        for(int i=x;i<=x+2;i++)
            for(int j=y;j<=y+2;j++)
                valid[grid[i][j]]++;
            
        for (int v = 1; v <= 9; v++)
            if (valid[v] != 1) return false;
        
        if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15)         return false;
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15)     return false;
        if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15)         return false;
        if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15)     return false;
        return true;
    }
}
