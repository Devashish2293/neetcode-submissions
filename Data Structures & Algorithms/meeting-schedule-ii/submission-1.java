class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            if (!rooms.isEmpty() && rooms.peek() <= meeting.start) {
                rooms.poll();
            }
            rooms.offer(meeting.end);
        }

        return rooms.size();
    }
}