class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(result, current, s, 0);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        // Base case: reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));  // ✅ Add a copy
            return;
        }

        // Try all possible substrings starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                current.add(substring);                          // Choose
                backtrack(result, current, s, end);              // Explore
                current.remove(current.size() - 1);              // Unchoose
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--; 
        }
        return true;
    }
}