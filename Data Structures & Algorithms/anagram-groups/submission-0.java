class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String,List<String>> map = new HashMap();


     for(String s : strs){
        int[] charCount = new int[26];
        for(char c : s.toCharArray()) 
        {
            charCount[c-'a']++;
        }
        String charCountString = Arrays.toString(charCount);
        if(map.containsKey(charCountString))
        {
            List list = map.get(charCountString);
            list.add(s);
            map.put(charCountString,list);
        }
        else
        {
            map.put(charCountString, new ArrayList<>(Arrays.asList(s)));
        }

     }
     return new ArrayList<>(map.values()); 
    }
}
