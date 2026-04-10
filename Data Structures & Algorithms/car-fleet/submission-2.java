class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        int fleet = 0;
        double prevTime = 0;
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (time > prevTime) {
                fleet++;
                prevTime = time;
            }
        }
        return fleet;
    }
}
