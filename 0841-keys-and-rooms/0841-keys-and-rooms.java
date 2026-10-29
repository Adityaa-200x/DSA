import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Track which rooms have been visited
        boolean[] visited = new boolean[rooms.size()];
        
        // Start traversing from room 0
        dfs(0, rooms, visited);
        
        // Check if any room was left unvisited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        // Mark the current room as visited
        visited[currentRoom] = true;
        
        // Iterate through all the keys found in the current room
        for (int key : rooms.get(currentRoom)) {
            // If the room corresponding to the key hasn't been visited, go to it
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}