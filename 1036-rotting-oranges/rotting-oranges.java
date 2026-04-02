import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // 1. Build initial state
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // Edge case: No fresh oranges to start with
        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. Multi-source BFS
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int nr = point[0] + dir[0];
                    int nc = point[1] + dir[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Infect
                        freshOranges--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            // If no more fresh oranges, we are done
            if (freshOranges == 0) return minutes;
        }

        return -1; // Some oranges stayed fresh
    }
}