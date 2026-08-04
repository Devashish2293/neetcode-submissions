class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int maxRows = board.length;
        int maxCols = board[0].length;
        boolean[][] visited = new boolean[maxRows][maxCols];
        for(int i = 0 ; i<maxRows;i++){
            for(int j = 0 ; j < maxCols; j++){
                if((i==0 || j==maxCols-1 || i==maxRows-1 || j == 0) && board[i][j]== 'O')
                    dfs(board,visited,i,j);
            }
        }
        for(int i = 0 ; i<maxRows;i++){
            for(int j = 0 ; j < maxCols; j++){
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }

    }
      public void dfs(char[][] board, boolean[][] visited, int row, int col) {
        int maxRows = board.length;
        int maxCols = board[0].length;
        
        if (row < 0 || row >= maxRows || col < 0 || col >= maxCols || visited[row][col] ||              board[row][col] != 'O') {
            return;
        }
        
        visited[row][col] = true;
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, visited, newRow, newCol);
        }
    }
}


