/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> a.start - b.start);

       if(intervals.isEmpty())
        return true;
        
        Interval current = intervals.get(0);
        
       
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < current.end) {
                return false;
            } else {
                // No overlap: move to next interval
                current = intervals.get(i);
            }
        }
        
        return true;
    }
}
