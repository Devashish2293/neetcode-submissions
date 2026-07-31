class Solution {
    class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> queue = new ArrayDeque();
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        int maxTime = 0;
        int freshOranges = 0;
        for(int i = 0 ; i <maxRows;i++)
        {
            for(int j = 0; j< maxCols; j++){
                if(grid[i][j] == 2)
                    queue.add(new Triplet(i,j,0));
                if(grid[i][j] == 1)
                    freshOranges++;  
            }
        }
        
        while(!queue.isEmpty()){
            Triplet or = queue.poll();
            int row= or.row,col = or.col, time = or.time;
            maxTime = Math.max(time,maxTime);
            //infecting up;
            if(row-1 >=0 && grid[row-1][col]==1){
                queue.offer(new Triplet(row-1,col,time+1));
                grid[row-1][col] = 2;
                freshOranges--;
            }

            //infecting down;
            if(row+1<maxRows && grid[row+1][col]==1){
                queue.offer(new Triplet(row+1,col,time+1));
                grid[row+1][col] = 2;
                freshOranges--;
            }

            //infecting left;
            if(col-1>=0 && grid[row][col-1]==1){
                queue.offer(new Triplet(row,col-1,time+1));
                grid[row][col-1] = 2;
                freshOranges--;

            }
            //infecting right;
            if(col+1<maxCols && grid[row][col+1]==1){
                queue.offer(new Triplet(row,col+1,time+1));
                grid[row][col+1] = 2;
                freshOranges--;
            }
        }
        return freshOranges>0?-1:maxTime;
    }
}
