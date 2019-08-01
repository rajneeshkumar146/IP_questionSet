package hnh;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class twitterdesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private class ListNode {
		int id;
		int time;
		ListNode next;

		public ListNode(int id, int time) {
			this.id = id;
			this.time = time;
		}

	}

	HashMap<Integer, ListNode> tweets;
	HashMap<Integer, Set<Integer>> follow;
	int time;

	public twitterdesign() {
		tweets = new HashMap<>();
		follow = new HashMap<>();
		time = 0;
	}

	public void posttweet(int userid, int tweetid) {
		ListNode ll = new ListNode(tweetid, time++);
		if (tweets.containsKey(userid)) {
			ListNode l = tweets.get(userid);
			ll.next = l;

		}
		tweets.put(userid, ll);
	}

	public ArrayList<Integer> getnewsfeed(int userid) {
		if (follow.containsKey(userid)) {
			follow.get(userid).add(userid);
		} else {
			Set<Integer> set = new HashSet<>();
			set.add(userid);
			follow.put(userid, set);
		}
		ArrayList<Integer> res = new ArrayList<>();
		PriorityQueue<ListNode> st = new PriorityQueue<>((a, b) -> b.time - a.time);
		for (int val : follow.get(userid)) {
			if (tweets.containsKey(val)) {
				st.offer(tweets.get(val));
			}
		}
		while (st.size() > 0) {
			ListNode lt = st.poll();
			ListNode next = lt.next;
			if (lt != null) {
		st.add(next);
			}
			res.add(lt.id);
		}
		return res;
	}

	public void follow(int follower, int followe) {
		if (follow.containsKey(follower)) {
			Set<Integer> s = follow.get(follower);
			s.add(followe);
			follow.put(follower, s);
		} else {
			Set<Integer> st = new HashSet<>();
			st.add(followe);
			follow.put(follower, st);

		}
	}

	public void unfollow(int follower, int followe) {
		follow.getOrDefault(follower, new HashSet<Integer>()).remove(followe);
	}
}
