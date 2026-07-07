class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(Character c : s.toCharArray()){
            if(c =='(' |c =='{' ||c =='[' ){
                    stack.push(c);
                    continue;
            }
               
            if(stack.isEmpty() || !isValidClosingBracket(stack.pop(),c))
                return false;    
        }
        return stack.isEmpty();
    }
     boolean isValidClosingBracket(Character openingBracket,Character closingBracket)
    {
       System.out.println(openingBracket + " " + closingBracket); 
       return (openingBracket == '('&& closingBracket == ')') ||
              (openingBracket == '{'&& closingBracket == '}') ||
              (openingBracket == '['&& closingBracket == ']')   ;
    }
}
