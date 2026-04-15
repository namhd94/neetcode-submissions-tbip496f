class WordDictionary {

    WordDictionary[] children = new WordDictionary[26];
    boolean isEndOfWord = false;

    public WordDictionary() {}

    public void addWord(String word) {
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // Bước 2: Nếu chưa có node cho ký tự này, tạo mới 🆕
            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionary();
            }
            // Bước 3: Di chuyển xuống node con 🏃‍♂️
            curr = curr.children[index];
        }
        // Bước cuối: Đánh dấu kết thúc từ 🚩
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, this);
    }

    private boolean searchInNode(String word, int index, WordDictionary node) {
        if (index == word.length()) return node.isEndOfWord;
        char c = word.charAt(index);
        if (c == '.') {
            // Thử tất cả 26 nhánh con 🚪
            for (WordDictionary child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) return true;
            }
            return false;
        } else {
            // Ký tự thường, đi vào nhánh tương ứng
            int childIndex = c - 'a';
            WordDictionary child = node.children[childIndex];
            if (child == null) return false;
            return searchInNode(word, index + 1, child);
        }
    }
}
