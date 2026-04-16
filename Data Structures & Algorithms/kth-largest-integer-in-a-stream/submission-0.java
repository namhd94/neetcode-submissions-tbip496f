class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val); // Thêm phần tử mới vào túi
        if (minHeap.size() > k) minHeap.poll(); // Loại phần tử bé nhất để giữ lại k phần tử lớn nhất
        return minHeap.peek(); // Đỉnh heap hiện tại chính là phẩn tử thứ k
    }
}
