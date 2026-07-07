class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //ArrayDeque<Integer> stack = new ArrayDeque();
        int[] result = new int[temperatures.length];
       for(int i = 0 ; i<temperatures.length ; i++)
        {   
            int count = 1;
            int j = i + 1; 
            while(j<temperatures.length && temperatures[j]<=temperatures[i])
            {
                count++;
                j++;
            }
            if(j<temperatures.length)
                //stack.push(count);
                result[i] = count;
            else
                //stack.push(0);    
                result[i] = 0;
        }
        //return stack.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
