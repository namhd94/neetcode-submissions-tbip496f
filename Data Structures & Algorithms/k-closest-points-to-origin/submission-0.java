class Solution {
    public int[][] kClosest(int[][] points, int k) {  
        // Max-Heap: Sắp xếp sao cho điểm xa gốc tọa độ hơn nằm ở đỉnh
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]),
                (a[0]*a[0] + a[1]*a[1])));
        for (int[] point: points) {
            maxHeap.add(point);
            // Nếu vượt quá k điểm, ta loại bỏ điểm XA NHẤT hiện tại
            if (maxHeap.size() > k) maxHeap.poll();
        }
        // Chuyển kết quả từ Heap sang mảng 2 chiều
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = maxHeap.poll();
        }
        return res;
    }
}
