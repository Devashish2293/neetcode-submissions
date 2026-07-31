class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>(); 
        maxHeap = new PriorityQueue<>((a, b) -> b - a);  
    }
    
    public void addNum(int num) {
        
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
      
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); 
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); 
        }
    }
    
    public double findMedian() {
        int total = maxHeap.size() + minHeap.size();
        
        if (total % 2 == 1) {
            return maxHeap.peek(); 
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;  
        }
    }
}