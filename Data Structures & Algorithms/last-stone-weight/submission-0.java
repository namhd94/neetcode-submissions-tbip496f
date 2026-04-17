class Solution {
    public int lastStoneWeight(int[] stones) {
        // Khởi tạo Max-Heap ⛰️
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : stones) maxHeap.add(num);

        // Đập đá cho đến khi còn ít hơn 2 viên 🔨
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Viên nặng thứ nhất
            int x = maxHeap.poll(); // Viên nặng thứ nhì

            if (y != x) maxHeap.add(y - x);
        }

        // Nếu còn đá thì trả về trọng lượng, không còn thì trả về 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
