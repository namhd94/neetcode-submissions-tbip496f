class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Thêm tất cả các khoảng nằm TRƯỚC và không liên quan đến newInterval (end < new.start)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // 2. Hợp nhất (Merge) tất cả các khoảng bị chồng lấn với newInterval (start <= new.end)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Chèn khoảng sau khi đã gộp xong
        // 3. Thêm tất cả các khoảng nằm SAU newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
