class Solution {
    public boolean searchMatrix(int[][] matrix, int target)
     {
        int totalRows = matrix.length;
        int totalCol = matrix[0].length;
       for(int i=0;i<totalRows;i++)
       {
            if(matrix[i][0]<=target && matrix[i][totalCol-1]>=target)
            {
                int index = Arrays.binarySearch(matrix[i],target);
                return index >= 0 ? true : false;
            }
       } 
       return  false;
    }
}
