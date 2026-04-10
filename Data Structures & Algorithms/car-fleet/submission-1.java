class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        int fleet = 0;
        double prevTime = 0;
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], (double)(target - position[i]) / speed[i]);
        }
        for (int key : map.keySet()) {
            double time = map.get(key);
            if (time > prevTime) {
                fleet++;
                prevTime = time;
            }
        }
        return fleet;
    }
}
