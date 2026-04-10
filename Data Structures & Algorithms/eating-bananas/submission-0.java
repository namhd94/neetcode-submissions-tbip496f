class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatInTime(piles, mid, h)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canEatInTime(int[] piles, int k, int h) {
        int hrs = 0;
        for (int pile: piles) {
            hrs += (pile + k - 1) / k;
        }
        return hrs <= h;
    }
}
