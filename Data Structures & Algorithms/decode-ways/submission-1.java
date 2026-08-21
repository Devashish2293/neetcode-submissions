class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];  
        Arrays.fill(dp, -1);             
        return decode(s, 0, dp);        
    }
    
    private int decode(String s, int index, int[] dp) {  
        
        if (index == s.length()) {
            return 1;
        }
        
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        // Option 1: Take 1 digit
        int ways = decode(s, index + 1, dp);
        
        // Option 2: Take 2 digits (if possible)
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit <= 26) {
                ways += decode(s, index + 2, dp);
            }
        }
        
        return dp[index] = ways;
    }
}