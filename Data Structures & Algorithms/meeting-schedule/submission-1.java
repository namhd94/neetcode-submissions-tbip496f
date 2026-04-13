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
        if (intervals.size() < 2) return true;
        // 1. Sắp xếp theo điểm bắt đầu (start time)
        intervals.sort((a, b) -> a.start - b.start);
        // Giả sử ta bắt đầu với khoảng đầu tiên
        Interval currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < currentInterval.end) return false;
            currentInterval = intervals.get(i);
        }
        return true;
    }
}
