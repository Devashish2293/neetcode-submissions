class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                count++;
                map.put(s.charAt(i), count);
                continue;
            }
            map.put(s.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int count = map.get(t.charAt(i));
                count--;
                if (count == 0)
                    map.remove(t.charAt(i));
                else
                    map.put(t.charAt(i), count);
                continue;
            }
            return false;
        }
        return true;
    }
}




/*
Time complexity: O(n+m)

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}
*/