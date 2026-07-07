class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque();
        for(String token: tokens){
            if(isNumber(token))
            {
                stack.push(Integer.parseInt(token));
                continue;
            }
            Integer num2 = stack.pop();
            Integer num1 = stack.pop();
            System.out.println(num1 +" "+ num2);
            if(token.equals("+"))
                stack.push(num1 + num2);
            else if(token.equals("-"))
                stack.push(num1 - num2);
            else if (token.equals("*"))
                stack.push(num1*num2);
            else
                stack.push(num1/num2);
        }
        return stack.pop();
    }
    boolean isNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            return num >= -200 && num <= 200;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
