class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0; // Mark visited
        int area = 1;   // Count current cell

        area += dfs(grid, r - 1, c); // Up
        area += dfs(grid, r + 1, c); // Down
        area += dfs(grid, r, c - 1); // Left
        area += dfs(grid, r, c + 1); // Right

        return area;
    }
}
