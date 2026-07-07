class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        
        for (int i = 0; i <= n; i++) {
            // When i == n, we use 0 as a sentinel to pop everything
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // While stack is not empty and current height is smaller
            // than the height at stack's top index
            //heights=[2,1,5,6,2,3]
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}