class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int left = 0;
        int right = rowCount * colCount - 1;

        while (left <= right) {  // ← Also fix this!
            int mid = left + (right - left) / 2;  
            int row = mid / colCount;              
            int col = mid % colCount;              
            
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}