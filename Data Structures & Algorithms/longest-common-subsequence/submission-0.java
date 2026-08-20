class Solution {
    static int[][] dp;
    public int lcs(int i,int j,StringBuilder text1, StringBuilder text2) {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j))
        {
            return dp[i][j] = 1 + lcs(i-1,j-1,text1,text2);
        }
        return dp[i][j] = Math.max(lcs(i,j-1,text1,text2),lcs(i-1,j,text1,text2));  
    }
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder sb1 = new StringBuilder(text1);
        StringBuilder sb2 = new StringBuilder(text2);
        int m = sb1.length() , n = sb2.length();
        dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],-1);
        }
        return lcs(m-1,n-1,sb1,sb2);
    }
}
