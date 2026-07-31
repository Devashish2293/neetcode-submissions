class Solution {
    public int numIslands(char[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        int numberofIslands = 0 ;
        for(int i = 0 ; i<maxRows ; i++){
            for(int j = 0 ; j<maxCols ; j++){
                if(grid[i][j] == '1')
                {
                    //bfs(i,j,grid);
                    bfs(i,j,grid);
                    numberofIslands++;
                }
            }
        }
        return numberofIslands;
    }
    
    public void bfs(int row,int col,char[][] grid){
        Queue<int[]> queue = new ArrayDeque();
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        queue.offer(new int[]{row, col});
        grid[row][col] = '.';
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int currRow = point[0];
            int currCol = point[1];

            //check up
            if(currRow-1>=0 && grid[currRow-1][currCol]=='1')
            {
                queue.offer(new int[]{currRow-1,currCol});
                grid[currRow-1][currCol] = '.';
            }

            //check down
            if(currRow+1<maxRows && grid[currRow+1][currCol]=='1')
            {
                queue.offer(new int[]{currRow+1,currCol});
                grid[currRow+1][currCol] = '.';
            }
            //check left
            if(currCol-1>=0 && grid[currRow][currCol-1]=='1')
            {
                queue.offer(new int[]{currRow,currCol-1});
                grid[currRow][currCol-1] = '.';
            }
            //check right
            if(currCol+1<maxCols && grid[currRow][currCol+1]=='1')
            {
                queue.offer(new int[]{currRow,currCol+1});
                grid[currRow][currCol+1] = '.';
            }
            
        }

    }

    public void dfs(int row, int col, char[][] grid) {
        // Base case: out of bounds or not land
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        
        // Mark as visited
        grid[row][col] = '.';
        
        // Explore all 4 directions
        dfs(row - 1, col, grid);  // up
        dfs(row + 1, col, grid);  // down
        dfs(row, col - 1, grid);  // left
        dfs(row, col + 1, grid);  // right
    }
}
