package com.m2017.august;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 355. Design Twitter
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * Created by a-mdx on 2017/8/10.
 * https://leetcode.com/problems/design-twitter/description/
 * Aug10
 * 这个程序非常好玩，原来设计类还能这么玩
 * 虽说说的话太多了，但是还是没那么难的
 * so exciting code...
 */
public class Twitter {

    private Map<Integer, List<Tweet>> userTweet;
    private Map<Integer, List<Integer>> userFollow;
    private int index = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        userTweet = new HashMap<>();
        userFollow = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        List<Tweet> tweets = userTweet.get(userId);
        if (tweets == null){
            tweets = new ArrayList<>();
        }
        tweets.add(new Tweet(tweetId, index++));

        userTweet.put(userId, tweets);

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweets = new ArrayList<>();

        List<Tweet> selfTweets = userTweet.get(userId);
        if (selfTweets == null){
            selfTweets = new ArrayList<>();
            userTweet.put(userId, selfTweets);
        }else {
            tweets.addAll(userTweet.get(userId));
        }

        // add follow
        List<Integer> follow = userFollow.get(userId);
        if (follow == null){
            follow = new ArrayList<>();
            userFollow.put(userId, follow);

        }else {
            for (Integer f : follow) {
                if (userTweet.get(f) != null) {
                    tweets.addAll(userTweet.get(f));
                }
            }
        }

        tweets = tweets.stream().sorted(Comparator.comparing(k -> -k.index)).limit(10).collect(Collectors.toList());
        List<Integer> ids = new ArrayList<>();
        tweets.forEach(k -> ids.add(k.tweetId));

        return ids;


    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        List<Integer> follow = userFollow.get(followerId);
        if (follow == null){
            follow = new ArrayList<>();
        }
        if (follow.contains(followeeId)){
            return;
        }
        follow.add(followeeId);
        userFollow.put(followerId, follow);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> follow = userFollow.get(followerId);
        if (follow == null){
            follow = new ArrayList<>();
        }
        if (!follow.contains(followeeId)){
            return;
        }
        follow.remove(Integer.valueOf(followeeId));
        userFollow.put(followerId, follow);
    }

    class Tweet implements Comparable<Tweet>{
        int tweetId;
        int index;
        Tweet(int tweetId, int index){
            this.tweetId = tweetId;
            this.index = index;
        }

        @Override
        public int compareTo(Tweet o) {
            return this.index - o.index;
        }
    }

    public static void main(String... args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.postTweet(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }



    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
