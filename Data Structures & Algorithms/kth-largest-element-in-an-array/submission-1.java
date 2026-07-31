class Solution {
    Queue<Integer> minHeap = new PriorityQueue();
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0 ; i<nums.length ; i++)
        {
            minHeap.offer(nums[i]);    
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
