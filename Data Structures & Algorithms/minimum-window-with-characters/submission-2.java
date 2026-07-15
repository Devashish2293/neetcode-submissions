class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        // 1. What we need
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 2. What we have in current window
        Map<Character, Integer> window = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int required = need.size();    // Unique characters we need
        int formed = 0;                // Unique characters satisfied
        
        String result = "";            // Best answer so far

        while (right < s.length()) {
            // ---- STEP 1: EXPAND ----
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // ---- STEP 2: SHRINK (while we have a valid window) ----
            while (formed == required && left <= right) {
                // Get current window
                String currentWindow = s.substring(left, right + 1);
                
                // Update result if this is the shortest so far
                if (result.equals("") || currentWindow.length() < result.length()) {
                    result = currentWindow;
                }

                // Remove left character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If we just broke a requirement, decrement formed
                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }

                left++;  // Shrink from left
            }

            right++;  // Expand from right
        }

        return result;
    }
}