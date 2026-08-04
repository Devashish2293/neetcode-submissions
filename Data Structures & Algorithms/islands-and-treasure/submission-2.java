class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        
        // Start BFS from each treasure chest 
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < maxRows && 
                    newCol >= 0 && newCol < maxCols && 
                    grid[newRow][newCol] == Integer.MAX_VALUE) {
                    
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}