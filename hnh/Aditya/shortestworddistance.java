package hnh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class shortestworddistance {

	 HashMap<String, ArrayList<Integer>> locations;

	    public WordDistance(String[] words) {
	        this.locations = new HashMap<String, ArrayList<Integer>>();

	        for (int i = 0; i < words.length; i++) {
	            ArrayList<Integer> loc = this.locations.getOrDefault(words[i], new ArrayList<Integer>());
	            loc.add(i);
	            this.locations.put(words[i], loc);
	        }
	    }

	    public int shortest(String word1, String word2) {
	        ArrayList<Integer> loc1, loc2;

	     
	        loc1 = this.locations.get(word1);
	        loc2 = this.locations.get(word2);

	        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
	        while (l1 < loc1.size() && l2 < loc2.size()) {
	            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
	            if (loc1.get(l1) < loc2.get(l2)) {
	                l1++;
	            } else {
	                l2++;
	            }
	        }

	        return minDiff;
	    }}
