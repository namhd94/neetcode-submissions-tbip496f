class PrefixTree {
    PrefixTree[] children = new PrefixTree[26];
    boolean isEndOfWord = false;
    public PrefixTree() {}
    public void insert(String word) {
        PrefixTree curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // Bước 2: Nếu chưa có node cho ký tự này, tạo mới 🆕
            if (curr.children[index] == null) {
                curr.children[index] = new PrefixTree();
            }
            // Bước 3: Di chuyển xuống node con 🏃‍♂️
            curr = curr.children[index];
        }
        // Bước cuối: Đánh dấu kết thúc từ 🚩
        curr.isEndOfWord = true;
    }
    public boolean search(String word) {
        PrefixTree node = searchPrefix(word);
        // Phải tồn tại đường đi VÀ node cuối cùng phải được đánh dấu là từ
        return node != null && node.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        // Chỉ cần tồn tại đường đi là đủ
        return searchPrefix(prefix) != null;
    }
    // Hàm phụ trợ để duyệt cây
    private PrefixTree searchPrefix(String prefix) {
        PrefixTree curr = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return null;
            curr = curr.children[index];
        }
        return curr;
    }
}
