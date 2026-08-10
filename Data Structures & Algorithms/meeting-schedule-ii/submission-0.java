class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // Min-heap to track earliest ending meeting
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            // If the earliest ending meeting ends before this one starts, reuse that room
            if (!rooms.isEmpty() && rooms.peek() <= meeting.start) {
                rooms.poll();
            }
            // Allocate a room (or reuse one)
            rooms.offer(meeting.end);
        }

        return rooms.size();
    }
}