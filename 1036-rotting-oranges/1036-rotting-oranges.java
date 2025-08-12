import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Collect all rotten oranges & count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;
        
        int minutes = -1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                for (int[] dir : directions) {
                    int nr = orange[0] + dir[0];
                    int nc = orange[1] + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot it
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        // Step 3: If fresh oranges remain, impossible
        return (freshCount == 0) ? minutes : -1;
    }
}
