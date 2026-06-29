class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left<right)
        {   
            if(!isAlphaNumeric(s.charAt(left)))
            {
                left++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(right)))
            {
                right--;
                continue;
            }
             if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char s)
    {
        return(s >= 'a' && s<='z') || (s >= 'A' && s<='Z') || (s>= '0' && s<= '9');
    }
}
