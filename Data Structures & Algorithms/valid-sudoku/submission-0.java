class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> col = new ArrayList<>();
        Map<Integer, Set<Character>> grid = new HashMap<>();

        // Initialize
        for(int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            grid.put(i, new HashSet<>());
        }

        // Check rows
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') 
                    continue;
                int gridIndex = (i / 3) * 3 + (j / 3); 
                if(row.get(i).contains(c) || 
                col.get(j).contains(c) || 
                grid.get(gridIndex).contains(c)) {
                    return false;
                }
                row.get(i).add(c);
                col.get(j).add(c);
                grid.get(gridIndex).add(c);
            }
        }

   

        return true;
    }
}