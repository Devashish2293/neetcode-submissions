class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap();
        int left = 0 , right = 0;
        String shortestSubstring="";
        for(char c : t.toCharArray())
        {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        while(right<s.length())
        {   
            Map<Character,Integer> countMap = new HashMap(map);
            if(!map.containsKey(s.charAt(left))){
                System.out.println("shift left" + left );

                left++;
                right++;
                continue;
            }
            while(!countMap.isEmpty() && right<s.length())
            {
                countMap.put(s.charAt(right),countMap.getOrDefault(s.charAt(right), 0) - 1);
                if(countMap.get(s.charAt(right))<=0)
                {
                    countMap.remove(s.charAt(right));
                }
                System.out.println(right);
                right++;
            }
            if(countMap.isEmpty())
            {
        
                String currSubstring = s.substring(left,right);
                System.out.println("curr="+currSubstring);
                if(shortestSubstring.equals("") || currSubstring.length()<shortestSubstring.length())
                    shortestSubstring = currSubstring;
            }
            else{
                return shortestSubstring;
            }
            left++;
            right=left;
        }
        return shortestSubstring;
    }
}
