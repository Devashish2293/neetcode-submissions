class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Create a copy of queries to track original order
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        
        // Map to store query -> result
        Map<Integer, Integer> map = new HashMap<>();
        
        // Min-heap: stores [length, end] for intervals containing current query
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int i = 0;
        for (int q : sortedQueries) {
            // Add all intervals that start <= q
            while (i < intervals.length && intervals[i][0] <= q) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int length = end - start + 1;
                minHeap.offer(new int[]{length, end});
                i++;
            }
            
            // Remove intervals that end < q
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            
            // The top of heap is the smallest interval containing q
            if (minHeap.isEmpty()) {
                map.put(q, -1);
            } else {
                map.put(q, minHeap.peek()[0]);
            }
        }
        
        // Build result in original query order
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = map.get(queries[j]);
        }
        return result;
    }
}