class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        if (list.size() == 1) return 1;
        int max = 0;
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) count += 1;
            else count = 1;
            max = Math.max(max, count);
        }
        return max;
    }
}
