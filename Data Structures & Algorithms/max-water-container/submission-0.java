class Solution {
    public int maxArea(int[] heights) {
        int left = 0 ;
        int right = heights.length - 1;
        int currentAmount;
        int maxAmount = 0;
        while(left<right)
        {
            currentAmount = (right - left) *  Math.min(heights[left],heights[right]);

            maxAmount = Math.max(maxAmount,currentAmount);
            if(heights[left]<heights[right])
                left++;
            else if(heights[left]>heights[right])
                right--;
            else  
            {  
                right--;
                left++;   
            }     
        }
       return maxAmount;

    }
}
