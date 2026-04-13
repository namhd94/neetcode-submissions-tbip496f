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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        // 1. Sắp xếp theo điểm bắt đầu (start time)
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> result = new PriorityQueue<>();
        result.offer(0);
        // Nếu meeting.start >= heap.peek() (phòng họp sớm nhất đã trống), ta lấy phòng đó ra (poll) và cập nhật end time mới vào.
        // Nếu không, ta phải mở thêm một phòng mới (add vào heap).
        for (Interval interval : intervals) {
            if (interval.start >= result.peek()) {
                result.poll();
                result.offer(interval.end);
            } else {
                result.add(interval.end);
            }
        }
        return result.isEmpty() ? 0 : result.size();
    }
}
