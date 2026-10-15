class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numberOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Iterate through every cell in the 2D grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If a cell with value '1' is found, it's a new island
                if (grid[r][c] == '1') {
                    numberOfIslands++;
                    // Run DFS to sink the entire connected island
                    dfs(grid, r, c);
                }
            }
        }
        
        return numberOfIslands;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base case: Check for out-of-bounds or if the cell is water ('0')
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }
        
        // Mark the current cell as visited by setting it to '0'
        grid[r][c] = '0';
        
        // Recursively visit all 4 adjacent directions
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}
