class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) 
            return false;
        
        int left = 0;
        int right = s1.length();
        int[] s1Hash = getHashArray(s1.toCharArray());
        int[] s2SubstringHash = getHashArray(s2.substring(0, s1.length()).toCharArray()); // First window
        
        // Check first window
        if (Arrays.equals(s1Hash, s2SubstringHash))
         return true;
        
        while (right < s2.length()) {
            // Slide window: remove left char, add right char
            s2SubstringHash[s2.charAt(left) - 'a']--;
            s2SubstringHash[s2.charAt(right) - 'a']++;
            
            left++;
            right++;
            
            if (Arrays.equals(s1Hash, s2SubstringHash)) return true;
        }
        return false;
    }

    public int[] getHashArray(char[] chars) {
        int arr[] = new int[26];
        for (char s : chars) {
            arr[s - 'a']++;
        }
        return arr;
    }
}