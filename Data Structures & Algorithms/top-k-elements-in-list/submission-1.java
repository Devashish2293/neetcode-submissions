class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums)
        {
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());      
        for(Map.Entry<Integer,Integer> entry : freq.entrySet())
        {
            maxHeap.offer(entry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();  
        }
        return result;
    }
}
