class Solution {
    
    //Static class
    public static class Square{
        int x;
        int y;
        int v;
        public Square(int x, int y, int v){
            this.x = x;
            this.y = y; 
            this.v = v;
        }
    }
    
    public int swimInWater(int[][] grid) {
        //Best first search using a priority queue - we use a min heap to always explore the best
        //node, if we get to the end then we have found the best path (minimum time)
        //Use a 2d boolean array to mark nodes as visited so that repeats are not explored
        
        //Make queue
        PriorityQueue<Square> queue = new PriorityQueue<Square>(new Comparator<Square>(){
            @Override
            public int compare(Square x, Square y){
                if (x.v == y.v) {
                    return 0;
                }
                return x.v > y.v ? 1 : -1;
            } 
        });
        
        //Add node the starting location to the queue
        boolean[][] visited = new boolean [grid.length][grid[0].length];
        queue.add(new Square(0,0,grid[0][0]));
        visited[0][0] = true;
           
        int max = 0;
        
        //While the queue is not empty explore the best path
        while (!queue.isEmpty()){
            Square next = queue.poll();
            max = (max > next.v) ? max : next.v;
            if ((next.x == grid.length-1) && (next.y == grid.length-1))
                break;
            exploreAdjacent(grid, visited, next.x, next.y, queue); 
        }      
        
        return max;
    }
    
    //exploreAdjacent explores all nodes around the current one we pulled from the minHeap priority queue
    //if the node has not yet been visited we add it to the queue and mark it as visited
    public void exploreAdjacent(int [][] grid, boolean[][] visited, int x, int y, PriorityQueue<Square> queue){
        if((x+1<grid.length) && visited[x+1][y] != true){
            queue.add(new Square(x+1, y, grid[x+1][y]));
            visited[x+1][y] = true;
        }
        
        if((y+1<grid[0].length) && visited[x][y+1] != true){
            queue.add(new Square(x, y+1, grid[x][y+1]));
            visited[x][y+1] = true;
        }
        
        if((x-1>=0) && visited[x-1][y] != true){
            queue.add(new Square(x-1, y, grid[x-1][y]));
            visited[x-1][y] = true;
        }
        
        if((y-1>=0) && visited[x][y-1] != true){
            queue.add(new Square(x, y-1, grid[x][y-1]));
            visited[x][y-1] = true;
        }
        
    }
}