class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int maxRows = heights.length;
        int maxCols = heights[0].length;
        
        boolean[][] pacific = new boolean[maxRows][maxCols];
        boolean[][] atlantic = new boolean[maxRows][maxCols];
        
        // Pacific Ocean: top row and left column
        for (int i = 0; i < maxRows; i++) {
            dfs(heights, i, 0, pacific);
        }
        for (int j = 0; j < maxCols; j++) {
            dfs(heights, 0, j, pacific);
        }
        
        // Atlantic Ocean: bottom row and right column
        for (int i = 0; i < maxRows; i++) {
            dfs(heights, i, maxCols - 1, atlantic);
        }
        for (int j = 0; j < maxCols; j++) {
            dfs(heights, maxRows - 1, j, atlantic);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    public void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < heights.length &&
                newCol >= 0 && newCol < heights[0].length &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {
                
                dfs(heights, newRow, newCol, visited);
            }
        }
    }
}