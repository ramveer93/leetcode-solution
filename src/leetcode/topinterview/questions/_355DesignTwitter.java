package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
 * the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5). twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2. twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6). twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. //
 * Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2. twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5], // since
 * user 1 is no longer following user 2. twitter.getNewsFeed(1);
 *
 */
public class _355DesignTwitter {

	private static HashMap<Integer, Set<Tweet>> tweetMap;
	private static HashMap<Integer, Set<Integer>> fans;
	int timeStamp = 0;

	public static void main(String[] args) {
		_355DesignTwitter twitter = new _355DesignTwitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println("  feed: " + twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println("Feed: ----" + twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(" Feed : " + twitter.getNewsFeed(1));
	}

	public _355DesignTwitter() {
		this.tweetMap = new HashMap<>();
		this.fans = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		Tweet newTweet = new Tweet(tweetId, timeStamp++);
		Set<Tweet> existingTweets = this.tweetMap.get(userId);
		if (existingTweets == null) {
			existingTweets = new HashSet<>();
		}
		existingTweets.add(newTweet);
		tweetMap.put(userId, existingTweets);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList<>();

		PriorityQueue<Tweet> recentTweets = new PriorityQueue<>(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				// TODO Auto-generated method stub
				return o2.getTime() - o1.getTime();
			}
		});
		// first find its own tweets
		Set<Tweet> existingTweets = this.tweetMap.get(userId);
		if (existingTweets != null) {
			recentTweets.addAll(existingTweets);
		}

		// now first find its followers
		Set<Integer> followers = this.fans.get(userId);
		if (followers != null) {
			for (int followerId : followers) {
				if (this.tweetMap.containsKey(followerId)) {
					recentTweets.addAll(this.tweetMap.get(followerId));
				}

			}

		}

		while (!recentTweets.isEmpty()) {
			res.add(recentTweets.poll().getTweetId());
			if (res.size() == 10)
				break;

		}

		return res;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		Set<Integer> existingFollowers = this.fans.get(followerId);
		if (existingFollowers == null) {
			existingFollowers = new HashSet<>();
		}
		existingFollowers.add(followeeId);
		this.fans.put(followerId, existingFollowers);

	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {

		Set<Integer> existingFollowers = this.fans.get(followerId);
		if (followerId == followeeId || existingFollowers == null)
			return;
		else {
			existingFollowers.remove(followeeId);
			this.fans.put(followerId, existingFollowers);
		}

	}

}

class Tweet {
	int tweetId;
	int time;

	public Tweet(int tweetId, int time) {
		this.tweetId = tweetId;
		this.time = time;
	}

	public int getTweetId() {
		return this.tweetId;
	}

	public int getTime() {
		return this.time;
	}

}
