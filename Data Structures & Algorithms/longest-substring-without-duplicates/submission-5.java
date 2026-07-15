class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int longestSubstring = 0;
        Set<Character> uniqueChars = new HashSet<>();
        if (s.equals(""))
            return 0;
 
        while (j < s.length()) {
            if (!uniqueChars.contains(s.charAt(j))) {
                uniqueChars.add(s.charAt(j));
                j++;
                longestSubstring = Math.max(uniqueChars.size(), longestSubstring);
            } else {
                uniqueChars.remove(s.charAt(i));
                i++;
            }
        }
        return longestSubstring;
    }
}