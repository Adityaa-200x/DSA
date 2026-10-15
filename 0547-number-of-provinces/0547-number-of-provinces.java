class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        for (int i = 0; i < n; i++) {
            // If the city hasn't been visited, it belongs to a new province
            if (!visited[i]) {
                provinces++;
                // Perform DFS to mark all connected cities as visited
                dfs(isConnected, visited, i);
            }
        }
        
        return provinces;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            // If city 'i' is connected to city 'j' and 'j' hasn't been visited yet
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
