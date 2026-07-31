class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int maxRows = grid.length;
        int maxCols = grid[0].length;
        int maxArea = 0;
        int numberofIslands = 0 ;
        for(int i = 0 ; i<maxRows ; i++){
            for(int j = 0 ; j<maxCols ; j++){
                if(grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea,bfs(i,j,grid));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int row,int col,int[][] grid){
        Queue<int[]> queue = new ArrayDeque();
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        int area = 1;
        queue.offer(new int[]{row, col});
        grid[row][col] = -1;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int currRow = point[0];
            int currCol = point[1];

            //check up
            if(currRow-1>=0 && grid[currRow-1][currCol]==1)
            {
                queue.offer(new int[]{currRow-1,currCol});
                grid[currRow-1][currCol] = -1;
                area++;
            }

            //check down
            if(currRow+1<maxRows && grid[currRow+1][currCol]==1)
            {
                queue.offer(new int[]{currRow+1,currCol});
                grid[currRow+1][currCol] = -1;
                area++;
            }
            //check left
            if(currCol-1>=0 && grid[currRow][currCol-1]==1)
            {
                queue.offer(new int[]{currRow,currCol-1});
                grid[currRow][currCol-1] = -1;
                area++;
            }
            //check right
            if(currCol+1<maxCols && grid[currRow][currCol+1]==1)
            {
                queue.offer(new int[]{currRow,currCol+1});
                grid[currRow][currCol+1] = -1;
                area++;
            }
            
        }
        return area;
    }
}
