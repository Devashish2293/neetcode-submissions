class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0) {
                    // Single character is always a palindrome
                    dp[i][j] = true;
                } else if (k == 1) {
                    // Two characters are a palindrome if they are identical
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // Check if the inner part is a palindrome and outer chars match
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
