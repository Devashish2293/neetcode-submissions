class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0 ; i<stones.length ; i++){
            maxHeap.offer(stones[i]);
        }

        while(!maxHeap.isEmpty())
        {
            if(maxHeap.size() == 1)
                return maxHeap.poll();
            int x = maxHeap.poll();
            int y = maxHeap.poll();    
            if(x==y)
                continue;
            else
                maxHeap.offer(Math.abs(y-x));    
        }

        return 0;

    }
}
