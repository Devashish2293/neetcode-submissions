class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        // Step 2: Start with the first interval
        int[] current = intervals[0];
        result.add(current);
        
        // Step 3: Process the rest
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            
            // If overlapping, merge
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                // If not overlapping, add as new interval
                current = next;
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}