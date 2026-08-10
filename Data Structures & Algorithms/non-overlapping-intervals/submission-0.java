class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int count = 0;
        int[] current = intervals[0];
        
        // Step 2: Process intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < current[1]) {
                // Overlap: increment count and keep the one with smaller end
                count++;
                if (intervals[i][1] < current[1]) {
                    current = intervals[i];
                }
            } else {
                // No overlap: move to next interval
                current = intervals[i];
            }
        }
        
        return count;
    }
}