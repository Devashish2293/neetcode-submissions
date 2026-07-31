class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        solve(result,map,digits,0,sb);
        return result;
    }
    public void solve(List<String> result,Map<Character,String> map,String digits,int index,StringBuilder sb)
    {
        if(digits.equals(""))
            return;
        if(index>=digits.length())
        {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String digitAlpha = map.get(c);
        for(int i = 0; i<digitAlpha.length();i++)
        {
            sb.append(digitAlpha.charAt(i)); //do
            solve(result,map,digits,index+1,sb); //explore
            sb.deleteCharAt(sb.length() - 1); //remove

        }
    }
}
