class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> counts = new HashMap<>();
        for (char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            int count = counts.getOrDefault(c, 0);
            if (count == 0) return false;
            counts.put(c, count - 1);
        }
        return true;
    }
}
