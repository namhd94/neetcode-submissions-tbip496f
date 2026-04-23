class Solution {
    public boolean canJump(int[] nums) {
        // Bước 1: Đích ban đầu là phần tử cuối cùng 🏁
        int goal = nums.length - 1;

        // Bước 2: Đi lùi từ cuối về đầu
        for (int i = nums.length - 2; i >= 0; i--) {
            // Nếu từ vị trí i có thể nhảy tới (hoặc vượt qua) đích hiện tại
            if (i + nums[i] >= goal) {
                goal = i; // Cập nhật đích mới gần hơn
            }
        }

        // Bước 3: Nếu đích lùi về được tận vạch xuất phát
        return goal == 0;
    }
}
