class Solution {
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        
        // Handle empty strings
        if (m == 0 || n == 0) return 0;
        
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, text1, text2);
    }
    
    private int solve(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve(i-1, j-1, text1, text2);
        }
        return dp[i][j] = Math.max(solve(i, j-1, text1, text2), 
                                   solve(i-1, j, text1, text2));
    }
}