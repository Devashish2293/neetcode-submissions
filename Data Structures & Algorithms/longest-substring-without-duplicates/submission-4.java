class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0,j=0;
        int longestSubstring = 1;
        Set uniqueChars = new HashSet();
        if(s.equals(""))
            return 0;
 
        while(j+1<s.length())
        {   
            j=i+1;
            uniqueChars.add(s.charAt(i));
            while(!uniqueChars.contains(s.charAt(j)))
            {
                uniqueChars.add(s.charAt(j));    
                j++;
                if(j+1>s.length())
                    break;

            }
            longestSubstring = Math.max(uniqueChars.size(),longestSubstring );
            uniqueChars.clear();
            i++;
        }
        return longestSubstring;
    }
}
