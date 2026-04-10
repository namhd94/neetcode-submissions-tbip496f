class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sắp xếp theo điểm bắt đầu (start time)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        // Giả sử ta bắt đầu với khoảng đầu tiên
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];
            if (nextStart <= currentEnd) {
                // Có chồng lấn! Cập nhật điểm kết thúc lớn nhất
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Không chồng lấn, thêm khoảng tiếp theo vào danh sách kết quả
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
