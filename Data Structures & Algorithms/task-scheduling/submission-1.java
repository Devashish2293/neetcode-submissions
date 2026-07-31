class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(Character c: tasks){
            freq[c-'A']++;
        }

        int maxFreq = 0 ;
        int maxCount = 0;
        int minTime;
        for(int i = 0 ; i < freq.length ; i++){
            maxFreq = Math.max(maxFreq,freq[i]);
        }
        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i] == maxFreq)
                maxCount++;
        } 
        minTime = (maxFreq-1) * (n+1) + maxCount;
        return Math.max(minTime,tasks.length);               
    }
}
