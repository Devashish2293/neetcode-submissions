class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet();
       int longest = 0;
       for(int n: nums)
       {
        set.add(n);
       }
       for(int n : set)
       {
         if(!set.contains(n-1))
         {
            int seq = 1;
            while(set.contains(n+seq))
            {
                seq++;
            }
            longest = Math.max(longest,seq);   
         }

       }    
       return longest;
    }
    
}
