class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] result = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k).mapToInt(Map.Entry::getKey).toArray();
        return result;
    }
}
