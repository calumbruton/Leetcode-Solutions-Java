class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] miniPath = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    miniPath[i][j] = grid[i][j];
                } else if (i == 0) {
                    miniPath[i][j] = grid[i][j] + miniPath[i][j - 1];
                } else if (j == 0) {
                    miniPath[i][j] = grid[i][j] + miniPath[i - 1][j];
                } else {
                    miniPath[i][j] = grid[i][j] + Math.min(miniPath[i][j - 1], miniPath[i - 1][j]);
                }
            }
        }
        return miniPath[m - 1][n - 1];
    }
}