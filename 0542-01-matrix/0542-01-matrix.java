import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Initialize the queue with all '0' cells and mark '1' cells as unvisited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Using MAX_VALUE to represent unvisited
                }
            }
        }
        
        // 4 cardinal directions: Up, Right, Down, Left
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // Step 2: Multi-Source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check boundaries and if a shorter path to a '0' is found
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (mat[nr][nc] > mat[r][c] + 1) {
                        mat[nr][nc] = mat[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return mat;
    }
}
