class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count number of frequency
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        // Max-Heap để luôn chọn việc có tần suất cao nhất
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f: freq) {
            if (f > 0) maxHeap.add(f);
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycleSize = n + 1; // Độ dài tối đa của một chu kỳ
            int taskCount = 0;

            // Cố gắng lấp đầy chu kỳ bằng các việc khác nhau
            for (int i = 0; i < cycleSize; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1); // Làm 1 việc, giảm tần suất
                    taskCount++;
                }
            }
            // Đưa các việc chưa xong quay lại Heap
            for (int f: temp) if (f > 0) maxHeap.add(f);

            // Nếu Heap rỗng, nghĩa là đây là chu kỳ cuối (không cộng idle)
            time += maxHeap.isEmpty() ? taskCount : cycleSize;
        }
        return time;
    }
}
