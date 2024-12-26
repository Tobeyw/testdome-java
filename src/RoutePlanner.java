
public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
          // Validate input
        if (mapMatrix == null || mapMatrix.length == 0 || mapMatrix[0].length == 0) {
            return false;
        }

        // If the starting or destination point is not a road, return false
        if (!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false;
        }

        int rows = mapMatrix.length;
        int cols = mapMatrix[0].length;

        // Create a visited matrix to track visited points
        boolean[][] visited = new boolean[rows][cols];

        // Use DFS to check if a path exists
        return dfs(fromRow, fromColumn, toRow, toColumn, mapMatrix, visited);
    }

    private static boolean dfs(int currentRow, int currentColumn, int toRow, int toColumn, boolean[][] mapMatrix, boolean[][] visited) {
        // Base case: If the current position is the destination, return true
        if (currentRow == toRow && currentColumn == toColumn) {
            return true;
        }

        // Mark the current cell as visited
        visited[currentRow][currentColumn] = true;

        // Define the directions for moving (up, down, left, right)
        int[] rowDirections = {-1, 1, 0, 0};
        int[] colDirections = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = currentRow + rowDirections[i];
            int newCol = currentColumn + colDirections[i];
           
            // Check if the new position is valid and not visited
            if (isValid(newRow, newCol, mapMatrix, visited)) {
                // Recursively try the next position
                if (dfs(newRow, newCol, toRow, toColumn, mapMatrix, visited)) {
                    return true;
                }
            }
        }

        // Backtrack: Unmark the cell (optional for boolean matrix)
        // visited[currentRow][currentColumn] = false; 

        return false;
    }
   
    private static boolean isValid(int row, int col, boolean[][] mapMatrix, boolean[][] visited) {
        return row >= 0 && row < mapMatrix.length &&
               col >= 0 && col < mapMatrix[0].length &&
               mapMatrix[row][col] && !visited[row][col];    //在地图内并且没被走过
    }

        
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };
        
        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}