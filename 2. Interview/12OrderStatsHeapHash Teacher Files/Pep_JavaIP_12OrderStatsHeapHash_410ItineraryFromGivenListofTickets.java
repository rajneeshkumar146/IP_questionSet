package OrderStatsHeapHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_12OrderStatsHeapHash_410ItineraryFromGivenListofTickets {
/**
 * Somewhat similar to topological sorting
 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		/**
		 * Key : Starting point
		 * Value : Destination
		 */
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			map.put(scn.next(), scn.next());
		}
		
		//List of starting points from original map
		ArrayList<String> al=new ArrayList<>(map.keySet());
		/**
		 * Key : Destination from original map
		 * Value : Source from orignial map
		 */
		HashMap<String, String> rev_map = new HashMap<>();
		for(String src: al) {
			rev_map.put(map.get(src), src);
		}
		
		//find starting point
		String start_point="";
			for(String src: al) {
			// if can not reach here, then it is starting point
			if(rev_map.containsKey(src)==false) {
				 start_point=src;
				break;
			}
		}
		String ans="";
		//iterate over orginal map from start point
		// change start point to vlaue of current start point
		while(map.containsKey(start_point)) {
			ans+=start_point+"->"+map.get(start_point)+" ";
			start_point=map.get(start_point);
		}
		
		System.out.println(ans);
	}

}
/*
Test cases:
4
Chennai Bangalore
Bombay Delhi
Goa Chennai
Delhi Goa
-------------------
Bombay->Delhi Delhi->Goa Goa->Chennai Chennai->Bangalore

4
Chennai Bangalore
Bombay Delhi
Hisar Chennai
Delhi Hisar
----------------------
Bombay->Delhi Delhi->Hisar Hisar->Chennai Chennai->Bangalore

5
Chennai Bangalore
Bombay Delhi
Goa Chennai
Delhi Goa
Bangalore Bhopal
-----------------------
Bombay->Delhi Delhi->Goa Goa->Chennai Chennai->Bangalore Bangalore->Bhopal

Source : https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
	*/