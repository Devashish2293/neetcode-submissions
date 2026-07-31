class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: Find max frequency and count how many tasks have it
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // Step 3: Calculate minimum time
        int minTime = (maxFreq - 1) * (n + 1) + maxCount;

        // Step 4: Return the max of tasks.length and minTime
        return Math.max(tasks.length, minTime);
    }
}