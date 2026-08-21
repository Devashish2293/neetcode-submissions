class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        
        boolean[][] dp = new boolean[n][n];
        int longest = -1;  
        int[] arr = new int[2];
        
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j]) {
                    int len = j - i + 1;  
                    if (len > longest) {
                        longest = len;
                        arr[0] = i;
                        arr[1] = j + 1;
                    }
                }
            }
        }
        return s.substring(arr[0], arr[1]);
    }
}