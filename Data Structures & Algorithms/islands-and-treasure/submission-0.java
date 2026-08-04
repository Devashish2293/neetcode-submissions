class Solution {

    public int[][] islandsAndTreasure(int[][] grid) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque();
        
        // start BFS from each treasure
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (grid[i][j] == 0) {  // All treasure chests
                    queue.offer(new int[]{i, j,0});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] treasure = queue.poll();
            int row=treasure[0],col = treasure[1],distance = treasure[2];
            //Filling up;
            if(row-1 >=0 && grid[row-1][col]==Integer.MAX_VALUE){
                queue.offer(new int[]{row-1, col,distance + 1});
                grid[row-1][col] = distance + 1;
            }

            //Filling down;
            if(row+1<maxRows && grid[row+1][col]==Integer.MAX_VALUE){
                queue.offer(new int[]{row+1, col,distance + 1});
                grid[row+1][col] = distance + 1;
            }

            //Filling left;
            if(col-1>=0 && grid[row][col-1]==Integer.MAX_VALUE){
                queue.offer(new int[]{row, col-1,distance + 1});
                grid[row][col-1] = distance + 1;
            }
            //Filling right;
            if(col+1<maxCols && grid[row][col+1]==Integer.MAX_VALUE ){
                queue.offer(new int[]{row, col+1,distance + 1});
                grid[row][col+1] = distance + 1;
            }
        }
        return grid;
    }



}
