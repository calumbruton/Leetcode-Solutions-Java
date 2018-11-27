class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> seen = new HashSet<Integer>();
        int m = matrix.length;  //num rows
        if (m == 0) return res;
        int n = matrix[0].length; //num columns
        int row = 0;
        int col = 0;
        

        while(seen.size() != m*n){
    
            //move right accross
            while(col < n && !seen.contains(matrix[row][col])){
                res.add(matrix[row][col]);
                seen.add(matrix[row][col]);
                col++;
            }
            col--;
            row++;
            
            //move down
            while(row < m && !seen.contains(matrix[row][col])){
                res.add(matrix[row][col]);
                seen.add(matrix[row][col]);
                row++;
            }
            row--;
            col--;
            
            //move left
            while(col >= 0 && !seen.contains(matrix[row][col])){
                res.add(matrix[row][col]);
                seen.add(matrix[row][col]);
                col--;
            }
            col++;
            row--;
            
            //move up
            while(row >= 0 && !seen.contains(matrix[row][col])){
                res.add(matrix[row][col]);
                seen.add(matrix[row][col]);
                row--;
            }
            row++;
            col++;   
            
        }    
        
        return res;
    }
}