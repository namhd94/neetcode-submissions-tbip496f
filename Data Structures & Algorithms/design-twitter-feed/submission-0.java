class Twitter {
    // 1. Thực thể Tweet đóng vai trò như một Node trong Linked List 🔗
    private static class Tweet {
        int id;
        int timestamp;
        Tweet next;

        Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    private int timer; // Bộ đếm thời gian toàn cục ⏱️
    private Map<Integer, Set<Integer>> followMap; // Quản lý followers 👥
    private Map<Integer, Tweet> tweetMap; // Quản lý bài đăng của từng user 📜

    public Twitter() {
        timer = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Đăng bài mới: Chèn vào đầu danh sách liên kết của User đó $O(1)$
    public void postTweet(int userId, int tweetId) {
        timer++;
        Tweet newTweet = new Tweet(tweetId, timer);
        // Lấy head cũ và nối vào sau tweet mới
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    // Lấy 10 bài mới nhất: Sử dụng thuật toán Merge K Sorted Lists với Heap
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        // Max-Heap: Ưu tiên tweet có timestamp lớn hơn (mới hơn) ⛰️
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        // Lấy danh sách những người đang follow (bao gồm chính mình)
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Luôn follow chính mình

        // Bước 1: Đưa bài đăng mới nhất (head) của mỗi người vào Heap
        for (int followeeId : followees) {
            Tweet head = tweetMap.get(followeeId);
            if (head != null) {
                maxHeap.add(head);
            }
        }

        // Bước 2: Trộn tin và lấy ra tối đa 10 bài
        
        while (!maxHeap.isEmpty() && res.size() < 10) {
            Tweet curr = maxHeap.poll();
            res.add(curr.id);
            
            // Nếu vẫn còn bài cũ hơn trong chuỗi của user đó, đẩy vào Heap
            if (curr.next != null) {
                maxHeap.add(curr.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // Không thể tự bỏ follow chính mình và chỉ thực hiện nếu có dữ liệu
        if (followerId != followeeId && followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}