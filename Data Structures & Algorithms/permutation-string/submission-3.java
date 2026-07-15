class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0 ;
        int right = s1.length();
        int s1Hash[] = getHashArray(s1.toCharArray());
        while(right<=s2.length())
        {   
            String subString = s2.substring(left, right);
            System.out.println("LEFT=" + left + " " + "RIGHT="+ right);
            if(Arrays.equals(s1Hash,getHashArray(subString.toCharArray())))
                return true;
            left++;
            right++;         
        }
        return false;
    }

    public int[] getHashArray(char[] chars)
    {
        int arr[] = new int[26];
        for(char s : chars)
        {
            arr[s-'a']++;
            //System.out.println(s + " " + arr[s-'a']);
            
        }
         //System.out.println("END");
        return arr;
    }
}
