class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        // case 1: Exclude last house (0 to n-2)
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = robRange(nums, 0, n - 2, dp1);
        
        // case 2: Exclude first house (1 to n-1)
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = robRange(nums, 1, n - 1, dp2);
        
        return Math.max(case1, case2);
    }
    
    private int robRange(int[] nums, int start, int end, int[] dp) {
        if (start > end) return 0;
        if (dp[start] != -1) return dp[start];
        
        int take = nums[start] + robRange(nums, start + 2, end, dp);
        
        int skip = robRange(nums, start + 1, end, dp);
        
        dp[start] = Math.max(take, skip);
        return dp[start];
    }
}