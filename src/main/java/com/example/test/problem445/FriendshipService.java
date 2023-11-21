package com.example.test.problem445;

import java.util.*;

public class FriendshipService {
    Map<Integer, Set<Integer>> followers;
    Map<Integer, Set<Integer>> following;
    public FriendshipService() {
        followers = new HashMap<>();
        following = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        if (!followers.containsKey(user_id)) return new ArrayList<>();
        List<Integer> list = new ArrayList(followers.get(user_id));
        Collections.sort(list);
        return list;
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        if (!following.containsKey(user_id)) return new ArrayList<>();
        List<Integer> list = new ArrayList(following.get(user_id));
        Collections.sort(list);
        return list;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        if (!followers.containsKey(to_user_id)) {
            followers.put(to_user_id, new HashSet<>());
        }

        if (!following.containsKey(from_user_id)) {
            following.put(from_user_id, new HashSet<>());
        }
        followers.get(to_user_id).add(from_user_id);
        following.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        if (!followers.containsKey(to_user_id)) return;
        if (!following.containsKey(from_user_id)) return;
        followers.get(to_user_id).remove(from_user_id);
        following.get(from_user_id).remove(to_user_id);
        if (followers.get(to_user_id).size() == 0) followers.remove(to_user_id);
        if (following.get(from_user_id).size() == 0) following.remove(from_user_id);
    }
}
