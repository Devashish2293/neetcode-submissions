class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int required = need.size();
        int formed = 0;
        
        // Track best window using indices (no substring creation)
        int minLength = Integer.MAX_VALUE;
        int bestLeft = 0;
        int bestRight = 0;

        while (right < s.length()) {
            // Expand window
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Shrink window
            while (formed == required && left <= right) {
                int currLength = right - left + 1;
                
                // Store best window (only indices, no substring!)
                if (currLength < minLength) {
                    minLength = currLength;
                    bestLeft = left;
                    bestRight = right;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }
            right++;
        }

        // Only create substring at the very end
        return minLength == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestRight + 1);
    }
}