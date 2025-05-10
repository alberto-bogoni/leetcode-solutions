import java.util.*;

class Twitter {
    Map<Integer, Set<Integer>> follows;
    Map<Integer, PriorityQueue<int[]>> tweets;
    Integer time = 0;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(
                userId,
                q -> new PriorityQueue<int[]>((a,b) -> b[0] - a[0])
        ).add(new int[] {time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> users = follows.getOrDefault(userId, new HashSet<Integer>());
        users.add(userId);
        for (Integer id : users) {
            for (int[] tId : tweets.getOrDefault(id, new PriorityQueue<int[]>())) {
                queue.add(tId);
            }
        }

        List<Integer> result = new ArrayList<>(10);
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            result.add(queue.poll()[1]);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, a -> new HashSet<Integer>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follows.get(followerId);
        if (followees == null) return;
        followees.remove(followeeId);
        follows.put(followerId, followees);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */